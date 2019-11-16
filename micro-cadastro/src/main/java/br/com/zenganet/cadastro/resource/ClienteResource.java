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

import br.com.zenganet.cadastro.service.ClienteService;
import br.com.zenganet.core.model.cadastro.Cliente;
import br.com.zenganet.core.model.cadastro.filter.ClienteFilter;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> pesquisar(@PathVariable Long codigo) {
		Optional<Cliente> cliente = clienteService.pesquisar(codigo);
		return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> pesquisar(ClienteFilter filtro, Pageable pageable) {
		Page<Cliente> clientes = clienteService.pesquisar(filtro, pageable);
		return clientes.getTotalElements() > 0 ? ResponseEntity.ok(clientes) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente entitySalvo = clienteService.inserir(cliente);		
		return ResponseEntity.status(HttpStatus.CREATED).body(entitySalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Valid @RequestBody Cliente cliente,	HttpServletResponse response) {
		Cliente clienteAtualizado = clienteService.atualizar(codigo, cliente);
		return ResponseEntity.ok(clienteAtualizado);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		clienteService.remover(codigo);
	}
	
}
