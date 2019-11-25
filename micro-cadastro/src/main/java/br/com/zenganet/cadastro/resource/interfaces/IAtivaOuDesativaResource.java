package br.com.zenganet.cadastro.resource.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IAtivaOuDesativaResource<Entity, Pk> {
	ResponseEntity<Entity> ativar(@PathVariable Pk pk);
	ResponseEntity<Entity> desativar(@PathVariable Pk pk);
}
