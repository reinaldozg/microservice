package br.com.zenganet.core.model.cadastro;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 3821524912889784487L;

	private Calendar inicio;

	@Column(name = "recebe_email")
	private boolean recebeEmail;

	@Size(max = 200)
	@Column(length = 200)
	private String observacao;

	@Column(name = "limite_compras")
	private BigDecimal limiteCompras;

	private boolean bloqueado;

	@Embedded
	private Controle controle;

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public boolean isRecebeEmail() {
		return recebeEmail;
	}

	public void setRecebeEmail(boolean recebeEmail) {
		this.recebeEmail = recebeEmail;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getLimiteCompras() {
		return limiteCompras;
	}

	public void setLimiteCompras(BigDecimal limiteCompras) {
		this.limiteCompras = limiteCompras;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}

}
