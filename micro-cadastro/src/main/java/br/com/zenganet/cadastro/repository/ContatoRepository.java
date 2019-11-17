package br.com.zenganet.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Contato;
import br.com.zenganet.core.model.cadastro.filter.ContatoFilter;


@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>, PesquisaRepositoryQuery<Contato,Long, ContatoFilter>{

}
