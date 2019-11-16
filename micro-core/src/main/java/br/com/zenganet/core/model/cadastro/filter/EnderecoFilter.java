package br.com.zenganet.core.model.cadastro.filter;

public class EnderecoFilter {

	private Integer cidade;
	private Integer estado;
	private Integer enderecoTipo;
	private String cep;
	private String logradouro;

	public Integer getCidade() {
		return cidade;
	}

	public void setCidade(Integer cidade) {
		this.cidade = cidade;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getEnderecoTipo() {
		return enderecoTipo;
	}

	public void setEnderecoTipo(Integer enderecoTipo) {
		this.enderecoTipo = enderecoTipo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
