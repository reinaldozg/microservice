package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.EnderecoTipo;
import br.com.zenganet.core.model.cadastro.filter.EnderecoTipoFilter;

@Repository
public interface EnderecoTipoRepository 
extends JpaRepository<EnderecoTipo, Long>, PesquisaRepositoryQuery<EnderecoTipo, Long, EnderecoTipoFilter>{
	
}
