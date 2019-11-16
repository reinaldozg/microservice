package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Endereco;
import br.com.zenganet.core.model.cadastro.filter.EnderecoFilter;

@Repository
public interface EnderecoRepository
		extends JpaRepository<Endereco, Long>, PesquisaRepositoryQuery<Endereco, EnderecoFilter> {

}
