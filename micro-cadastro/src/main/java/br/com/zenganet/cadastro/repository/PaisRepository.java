package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Pais;
import br.com.zenganet.core.model.cadastro.filter.PaisFilter;

@Repository
public interface PaisRepository
		extends JpaRepository<Pais, Long>, PesquisaRepositoryQuery<Pais, PaisFilter> {

}
