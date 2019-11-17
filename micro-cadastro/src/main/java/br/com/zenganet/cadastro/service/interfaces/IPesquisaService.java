package br.com.zenganet.cadastro.service.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPesquisaService<Entity,Pk, Filter> {
	Page<Entity> pesquisar(Filter filter, Pageable pageable);
	Optional<Entity> pesquisar(Pk pk);
}
