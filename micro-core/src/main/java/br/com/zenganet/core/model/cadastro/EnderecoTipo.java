package br.com.zenganet.core.model.cadastro;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "endereco_tipo")
public class EnderecoTipo extends PadraoEntityPublishable {

	private static final long serialVersionUID = 6364106329607118474L;

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
