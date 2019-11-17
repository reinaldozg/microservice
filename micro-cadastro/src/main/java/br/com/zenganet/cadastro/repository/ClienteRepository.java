package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Cliente;
import br.com.zenganet.core.model.cadastro.filter.ClienteFilter;
import br.com.zenganet.core.model.cadastro.projection.ClienteMobileProjection;

@Repository
@RepositoryRestResource(excerptProjection = ClienteMobileProjection.class)
public interface ClienteRepository 
	extends JpaRepository<Cliente, Long>, PesquisaRepositoryQuery<Cliente,Long, ClienteFilter> {

}
