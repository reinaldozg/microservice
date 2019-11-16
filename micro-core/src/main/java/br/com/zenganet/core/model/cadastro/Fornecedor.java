package br.com.zenganet.core.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name = "id")
public class Fornecedor extends Pessoa {

	private static final long serialVersionUID = -5295870017821828061L;

	@Column(length = 200)
	private String observacao;

	@Column(name = "codigo_rural", length = 50)
	private String codigoRural;

	@Column(length = 20)
	private String responsavel;

	private boolean fabricante;

	private boolean bloqueado;

	@Embedded
	private Controle controle;

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getCodigoRural() {
		return codigoRural;
	}

	public void setCodigoRural(String codigoRural) {
		this.codigoRural = codigoRural;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public boolean isFabricante() {
		return fabricante;
	}

	public void setFabricante(boolean fabricante) {
		this.fabricante = fabricante;
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
