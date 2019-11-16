package br.com.zenganet.cadastro.repository.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PesquisaRepositoryQuery<E, F> {	
	Page<E> pesquisar(F filter, Pageable pageable);
}
