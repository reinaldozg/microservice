package br.com.zenganet.cadastro.resource.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPesquisaResource<Entity, Pk, Filter> {
	
	ResponseEntity<Entity> pesquisar(Pk codigo);	
	ResponseEntity<Page<Entity>> pesquisar(Filter filtro, Pageable pageable);	

	
}
