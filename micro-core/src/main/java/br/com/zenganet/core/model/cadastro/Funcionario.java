package br.com.zenganet.core.model.cadastro;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "id")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 8850836563490552039L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cargo")
	private Cargo cargo;

	@Column(length = 10)
	private String matricula;

	@Column(length = 10)
	private String cpts;

	@Column(name = "cpts_serie", length = 10)
	private String cptsSerie;

	@Column(name = "cpts_data_emissao")
	private Calendar cptsDataEmissao;

	@Column(name = "data_admissao")
	private Calendar dataAdmissao;

	@Column(name = "data_demissao")
	private Calendar dataDemissao;

	@Column(name = "demissao_motivo", length = 200)
	private String demissaoMotivo;

	@Column(name = "titulo_inscricao", length = 15)
	private String tituloInscricao;

	@Column(name = "titulo_zona", length = 5)
	private String tituloZona;

	@Column(name = "titulo_secao", length = 5)
	private String tituloSecsao;

	@Column(name = "titulo_data_admissao")
	private Calendar tituloDataAdmissao;

	@Column(length = 15)
	private String pis;

	@Column(name = "reservista_ra", length = 15)
	private String reservistaRa;

	@Column(name = "reservista_data_in")
	private Calendar reservistaDataIn;

	@Column(name = "banco_numero_conta", length = 10)
	private String bancoNumeroConta;

	@Column(name = "banco_agencia", length = 10)
	private String bancoAgencia;
	
	@Embedded
	private Controle controle;

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

	public Calendar getCptsDataEmissao() {
		return cptsDataEmissao;
	}

	public void setCptsDataEmissao(Calendar cptsDataEmissao) {
		this.cptsDataEmissao = cptsDataEmissao;
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

	public String getTituloZona() {
		return tituloZona;
	}

	public void setTituloZona(String tituloZona) {
		this.tituloZona = tituloZona;
	}

	public String getTituloSecsao() {
		return tituloSecsao;
	}

	public void setTituloSecsao(String tituloSecsao) {
		this.tituloSecsao = tituloSecsao;
	}

	public Calendar getTituloDataAdmissao() {
		return tituloDataAdmissao;
	}

	public void setTituloDataAdmissao(Calendar tituloDataAdmissao) {
		this.tituloDataAdmissao = tituloDataAdmissao;
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

	public Calendar getReservistaDataIn() {
		return reservistaDataIn;
	}

	public void setReservistaDataIn(Calendar reservistaDataIn) {
		this.reservistaDataIn = reservistaDataIn;
	}

	public String getBancoNumeroConta() {
		return bancoNumeroConta;
	}

	public void setBancoNumeroConta(String bancoNumeroConta) {
		this.bancoNumeroConta = bancoNumeroConta;
	}

	public String getBancoAgencia() {
		return bancoAgencia;
	}

	public void setBancoAgencia(String bancoAgencia) {
		this.bancoAgencia = bancoAgencia;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}
	
}
