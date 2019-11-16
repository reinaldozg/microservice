package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Fornecedor;
import br.com.zenganet.core.model.cadastro.filter.FornecedorFilter;
import br.com.zenganet.core.model.cadastro.projection.FornecedorMobileProjection;

@Repository
@RepositoryRestResource(excerptProjection = FornecedorMobileProjection.class)
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> , PesquisaRepositoryQuery<Fornecedor, FornecedorFilter>{

}
