package br.com.zenganet.core.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contato")
public class Contato extends PadraoEntityPublishable {

	private static final long serialVersionUID = -5754072872046760937L;

	@ManyToOne
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "contato_tipo")
	private ContatoTipo contatoTipo;

	@Size(max = 50)
	@Column(length = 50)
	private String nome;

	@Size(max = 80)
	@Column(length = 80)
	private String contato;

	private boolean principal;

	@Embedded
	private Controle controle;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ContatoTipo getContatoTipo() {
		return contatoTipo;
	}

	public void setContatoTipo(ContatoTipo contatoTipo) {
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

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}

}
