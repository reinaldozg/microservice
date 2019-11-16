package br.com.zenganet.core.model.cadastro;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
public class Cargo extends PadraoEntityPublishable {

	private static final long serialVersionUID = 8214681006693168861L;

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
