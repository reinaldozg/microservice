package br.com.zenganet.cadastro.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenganet.cadastro.resource.interfaces.IPesquisaResource;
import br.com.zenganet.cadastro.service.CidadeService;
import br.com.zenganet.core.model.cadastro.Cidade;
import br.com.zenganet.core.model.cadastro.filter.CidadeFilter;

@RestController
@RequestMapping("/cidades")
public class CidadeResource implements IPesquisaResource<Cidade, Integer, CidadeFilter>{

	@Autowired
	private CidadeService service;
	
	@Override @GetMapping("/{codigo}")
	public ResponseEntity<Cidade> pesquisar(@PathVariable Integer codigo) {
		Optional<Cidade> cidade = service.pesquisar(codigo);
		return cidade.isPresent() ? ResponseEntity.ok(cidade.get()) : ResponseEntity.notFound().build();
	}

	@Override @GetMapping
	public ResponseEntity<Page<Cidade>> pesquisar(CidadeFilter filtro, Pageable pageable) {
		Page<Cidade> cidades = service.pesquisar(filtro, pageable);
		return cidades.getTotalElements() > 0 ? ResponseEntity.ok(cidades) : ResponseEntity.notFound().build();
	}

}
