package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Funcionario;
import br.com.zenganet.core.model.cadastro.filter.FuncionarioFilter;
import br.com.zenganet.core.model.cadastro.projection.FuncionarioMobileProjection;

@Repository
@RepositoryRestResource(excerptProjection = FuncionarioMobileProjection.class)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>, PesquisaRepositoryQuery<Funcionario, Long, FuncionarioFilter>{

}
