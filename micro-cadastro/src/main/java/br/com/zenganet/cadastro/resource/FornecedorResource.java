package br.com.zenganet.cadastro.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenganet.cadastro.service.FornecedorService;
import br.com.zenganet.core.model.cadastro.Fornecedor;
import br.com.zenganet.core.model.cadastro.filter.FornecedorFilter;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorResource {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Fornecedor> pesquisar(@PathVariable Long codigo) {
		Optional<Fornecedor> fornecedor = fornecedorService.pesquisar(codigo);
		return fornecedor.isPresent() ? ResponseEntity.ok(fornecedor.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<Fornecedor>> pesquisar(FornecedorFilter filtro, Pageable pageable) {
		Page<Fornecedor> fornecedores = fornecedorService.pesquisar(filtro, pageable);
		return fornecedores.getTotalElements() > 0 ? ResponseEntity.ok(fornecedores) : ResponseEntity.notFound().build();
	}
	
	@PostMapping	
	public ResponseEntity<Fornecedor> inserir(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response) {
		Fornecedor entitySalvo = fornecedorService.inserir(fornecedor);		
		return ResponseEntity.status(HttpStatus.CREATED).body(entitySalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Fornecedor> atualizar(@PathVariable Long codigo, @Valid @RequestBody Fornecedor fornecedor,	HttpServletResponse response) {
		Fornecedor fornecedorAtualizado = fornecedorService.atualizar(codigo, fornecedor);
		return ResponseEntity.ok(fornecedorAtualizado);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		fornecedorService.remover(codigo);
	}
	
}
