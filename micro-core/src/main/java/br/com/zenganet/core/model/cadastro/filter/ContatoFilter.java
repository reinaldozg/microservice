package br.com.zenganet.core.model.cadastro.filter;

public class ContatoFilter {

	private String contatoTipo;

	private String nome;

	private String contato;

	private boolean principal;

	public String getContatoTipo() {
		return contatoTipo;
	}

	public void setContatoTipo(String contatoTipo) {
		this.contatoTipo = contatoTipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

}
