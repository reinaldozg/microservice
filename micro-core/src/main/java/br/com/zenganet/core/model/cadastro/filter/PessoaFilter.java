package br.com.zenganet.core.model.cadastro.filter;

import java.util.Calendar;

public class PessoaFilter {

	private String cnpjOuCpf;

	private String inscEstadualOuEstCivil;

	private String inscMunicipalOuRg;

	private String nomeFantasiaOuSexo;

	private String nomeOuRazaoSocial;

	private Calendar dataNascimento;

	public String getCnpjOuCpf() {
		return cnpjOuCpf;
	}

	public void setCnpjOuCpf(String cnpjOuCpf) {
		this.cnpjOuCpf = cnpjOuCpf;
	}

	public String getInscEstadualOuEstCivil() {
		return inscEstadualOuEstCivil;
	}

	public void setInscEstadualOuEstCivil(String inscEstadualOuEstCivil) {
		this.inscEstadualOuEstCivil = inscEstadualOuEstCivil;
	}

	public String getInscMunicipalOuRg() {
		return inscMunicipalOuRg;
	}

	public void setInscMunicipalOuRg(String inscMunicipalOuRg) {
		this.inscMunicipalOuRg = inscMunicipalOuRg;
	}

	public String getNomeFantasiaOuSexo() {
		return nomeFantasiaOuSexo;
	}

	public void setNomeFantasiaOuSexo(String nomeFantasiaOuSexo) {
		this.nomeFantasiaOuSexo = nomeFantasiaOuSexo;
	}

	public String getNomeOuRazaoSocial() {
		return nomeOuRazaoSocial;
	}

	public void setNomeOuRazaoSocial(String nomeOuRazaoSocial) {
		this.nomeOuRazaoSocial = nomeOuRazaoSocial;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
