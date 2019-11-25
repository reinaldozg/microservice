package br.com.zenganet.cadastro.resource.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface IBloqueiaOuDesbloqueiaResource<Entity, Pk> {
	ResponseEntity<Entity> bloquear(@PathVariable Pk pk);
	ResponseEntity<Entity> desbloquear(@PathVariable Pk pk);
}
