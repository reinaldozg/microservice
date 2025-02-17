package br.com.zenganet.cadastro.repository.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PesquisaRepositoryQuery<Entity, Pk, Filter> {
	Optional<Entity> pesquisar(Pk pk);
	Page<Entity> pesquisar(Filter filter, Pageable pageable);
}
