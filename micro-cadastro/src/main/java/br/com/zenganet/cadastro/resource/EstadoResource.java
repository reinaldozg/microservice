package br.com.zenganet.cadastro.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenganet.cadastro.resource.interfaces.IPesquisaResource;
import br.com.zenganet.cadastro.service.EstadoService;
import br.com.zenganet.core.model.cadastro.Estado;
import br.com.zenganet.core.model.cadastro.filter.EstadoFilter;

@RestController
@RequestMapping("/estados")
public class EstadoResource implements IPesquisaResource<Estado, Integer, EstadoFilter>{

	@Autowired private EstadoService service;
	
	@Override @GetMapping("/{codigo}")
	public ResponseEntity<Estado> pesquisar(Integer codigo) {
		Optional<Estado> estado = service.pesquisar(codigo);
		return estado.isPresent() ? ResponseEntity.ok(estado.get()) : ResponseEntity.notFound().build();
	}
	
	@Override @GetMapping
	public ResponseEntity<Page<Estado>> pesquisar(EstadoFilter filtro, Pageable pageable) {
		Page<Estado> estados = service.pesquisar(filtro, pageable);
		return estados.getTotalElements() > 0 ? ResponseEntity.ok(estados) : ResponseEntity.notFound().build();
	}

}
