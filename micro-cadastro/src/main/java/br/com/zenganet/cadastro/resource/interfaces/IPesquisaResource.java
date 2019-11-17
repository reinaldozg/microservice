package br.com.zenganet.cadastro.resource.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPesquisaResource<Entity, Pk, Filter> {
	
	ResponseEntity<Entity> pesquisar(@PathVariable Pk codigo);	
	ResponseEntity<Page<Entity>> pesquisar(Filter filtro, Pageable pageable);	

	
}
