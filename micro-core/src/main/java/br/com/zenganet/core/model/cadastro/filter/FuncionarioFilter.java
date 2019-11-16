package br.com.zenganet.core.model.cadastro.filter;

import java.util.Calendar;

public class FuncionarioFilter extends PessoaFilter {

	private String cargo;
	
	private String matricula;

	private String cpts;

	private String cptsSerie;

	private Calendar dataAdmissao;

	private Calendar dataDemissao;

	private String demissaoMotivo;

	private String tituloInscricao;

	private String pis;

	private String reservistaRa;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpts() {
		return cpts;
	}

	public void setCpts(String cpts) {
		this.cpts = cpts;
	}

	public String getCptsSerie() {
		return cptsSerie;
	}

	public void setCptsSerie(String cptsSerie) {
		this.cptsSerie = cptsSerie;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Calendar getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Calendar dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public String getDemissaoMotivo() {
		return demissaoMotivo;
	}

	public void setDemissaoMotivo(String demissaoMotivo) {
		this.demissaoMotivo = demissaoMotivo;
	}

	public String getTituloInscricao() {
		return tituloInscricao;
	}

	public void setTituloInscricao(String tituloInscricao) {
		this.tituloInscricao = tituloInscricao;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getReservistaRa() {
		return reservistaRa;
	}

	public void setReservistaRa(String reservistaRa) {
		this.reservistaRa = reservistaRa;
	}

}
