package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.ContatoTipo;
import br.com.zenganet.core.model.cadastro.filter.ContatoTipoFilter;

@Repository
public interface ContatoTipoRepository 
extends JpaRepository<ContatoTipo, Long>, PesquisaRepositoryQuery<ContatoTipo, ContatoTipoFilter>{
	
}
