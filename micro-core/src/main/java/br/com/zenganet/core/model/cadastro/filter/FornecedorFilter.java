package br.com.zenganet.core.model.cadastro.filter;

public class FornecedorFilter extends PessoaFilter {

	private String codigoRural;

	private String responsavel;

	private boolean fabricante;

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

}
