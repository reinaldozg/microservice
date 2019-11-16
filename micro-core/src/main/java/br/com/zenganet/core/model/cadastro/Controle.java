package br.com.zenganet.core.model.cadastro;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Embeddable;

@Embeddable
public class Controle implements Serializable {

	private static final long serialVersionUID = 2053009605632461045L;

	private Calendar dataInclusao;
	private Calendar ultimaAtualizacao;

	private boolean excluido;

	private boolean ativo;

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Calendar getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Calendar ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
