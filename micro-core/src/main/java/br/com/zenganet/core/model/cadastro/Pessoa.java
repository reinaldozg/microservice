package br.com.zenganet.core.model.cadastro;

import java.util.Calendar;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends PadraoEntityPublishable{

	private static final long serialVersionUID = 8271548026315998395L;
	
	@Column(name = "pessoa_tipo", length = 8)
	@Enumerated(EnumType.STRING)
	private PessoaTipo pessoaTipo;

	@Column(name = "cnpj_ou_cpf", length = 14)
	private String cnpjOuCpf;

	@Column(name = "insc_estadual_ou_est_civil", length = 20)
	private String inscEstadualOuEstCivil;

	@Column(name = "insc_municipal_ou_rg", length = 20)
	private String inscMunicipalOuRg;

	@Column(name = "nome_fantasia_ou_sexo", length = 50)
	private String nomeFantasiaOuSexo;

	@Column(name = "nome_ou_razao_social", length = 80)
	private String nomeOuRazaoSocial;

	@Column(name = "data_nascimento")
	private Calendar dataNascimento;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private Set<Contato> contatos;
	
	@OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
	private Set<Endereco> enderecos;

	public PessoaTipo getPessoaTipo() {
		return pessoaTipo;
	}

	public void setPessoaTipo(PessoaTipo pessoaTipo) {
		this.pessoaTipo = pessoaTipo;
	}

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

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
