package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Estado;
import br.com.zenganet.core.model.cadastro.filter.EstadoFilter;

@Repository
public interface EstadoRepository
		extends JpaRepository<Estado, Integer>, PesquisaRepositoryQuery<Estado, Integer, EstadoFilter> {

}
