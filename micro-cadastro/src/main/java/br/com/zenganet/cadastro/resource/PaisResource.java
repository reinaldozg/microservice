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
import br.com.zenganet.cadastro.service.PaisService;
import br.com.zenganet.core.model.cadastro.Pais;
import br.com.zenganet.core.model.cadastro.filter.PaisFilter;

@RestController
@RequestMapping("/paises")
public class PaisResource implements IPesquisaResource<Pais, Integer, PaisFilter> {

	@Autowired private PaisService service;

	@Override @GetMapping("/{codigo}")
	public ResponseEntity<Pais> pesquisar(Integer codigo) {
		Optional<Pais> pais = service.pesquisar(codigo);
		return pais.isPresent() ? ResponseEntity.ok(pais.get()) : ResponseEntity.notFound().build();
	}

	@Override @GetMapping
	public ResponseEntity<Page<Pais>> pesquisar(PaisFilter filtro, Pageable pageable) {
		Page<Pais> paises = service.pesquisar(filtro, pageable);
		return paises.getTotalElements() > 0 ? ResponseEntity.ok(paises) : ResponseEntity.notFound().build();
	}
}
