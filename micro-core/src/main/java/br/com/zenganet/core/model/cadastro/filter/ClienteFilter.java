package br.com.zenganet.core.model.cadastro.filter;

import java.math.BigDecimal;
import java.util.Calendar;

public class ClienteFilter extends PessoaFilter{

	private Calendar inicio;

	private boolean recebeEmail;

	private BigDecimal limiteCompras;

	private boolean ativo;

	private boolean bloqueado;

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

	public BigDecimal getLimiteCompras() {
		return limiteCompras;
	}

	public void setLimiteCompras(BigDecimal limiteCompras) {
		this.limiteCompras = limiteCompras;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

}
