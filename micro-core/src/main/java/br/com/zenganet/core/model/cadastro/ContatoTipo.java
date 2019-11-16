package br.com.zenganet.core.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "contato_tipo")
public class ContatoTipo extends PadraoEntityPublishable {

	private static final long serialVersionUID = 902030606324275814L;

	@Size(max = 50)
	@Column(length = 50)
	private String descricao;
	
	@Embedded
	private Controle controle;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Controle getControle() {
		return controle;
	}

	public void setControle(Controle controle) {
		this.controle = controle;
	}

}
