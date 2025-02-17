package br.com.zenganet.cadastro.resource;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenganet.cadastro.resource.interfaces.IAtivaOuDesativaResource;
import br.com.zenganet.cadastro.resource.interfaces.IBloqueiaOuDesbloqueiaResource;
import br.com.zenganet.cadastro.resource.interfaces.IPesquisaResource;
import br.com.zenganet.cadastro.resource.interfaces.IRemoveResource;
import br.com.zenganet.cadastro.resource.interfaces.ISalvaResource;
import br.com.zenganet.cadastro.service.ClienteService;

import br.com.zenganet.core.model.cadastro.Cliente;
import br.com.zenganet.core.model.cadastro.filter.ClienteFilter;

@RestController
@RequestMapping("/clientes")
public class ClienteResource 
	implements 
		IPesquisaResource<Cliente, Long, ClienteFilter>, 
		ISalvaResource<Cliente, Long>,
		IRemoveResource<Long>,
		IAtivaOuDesativaResource<Cliente, Long>,
		IBloqueiaOuDesbloqueiaResource<Cliente, Long>{

	@Autowired
	private ClienteService service;
	
	@Override @GetMapping("/{codigo}")
	public ResponseEntity<Cliente> pesquisar(@PathVariable Long codigo) {
		Optional<Cliente> cliente = service.pesquisar(codigo);
		return cliente.isPresent() ? ResponseEntity.ok(cliente.get()) : ResponseEntity.notFound().build();
	}

	@Override @GetMapping
	public ResponseEntity<Page<Cliente>> pesquisar(ClienteFilter filtro, Pageable pageable) {
		Page<Cliente> clientes = service.pesquisar(filtro, pageable);
		return clientes.getTotalElements() > 0 ? ResponseEntity.ok(clientes) : ResponseEntity.notFound().build();
	}

	@Override @PostMapping
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente, BindingResult result, HttpServletResponse response) {
		Cliente entitySalvo = service.inserir(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(entitySalvo);
	}

	@Override @PutMapping("/{codigo}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Valid @RequestBody Cliente cliente, BindingResult result,
			HttpServletResponse response) {
		Cliente clienteAtualizado = service.atualizar(codigo, cliente);
		return ResponseEntity.ok(clienteAtualizado);
	}

	@Override @DeleteMapping("/{codigo}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		service.remover(codigo);
	}
	
	@PatchMapping("ativar/{codigo}")
	public ResponseEntity<Cliente> ativar(@PathVariable Long codigo) {
		Cliente clienteAtualizado = service.ativar(codigo);
		return ResponseEntity.ok(clienteAtualizado);
	}

	@PatchMapping("desativar/{codigo}")
	public ResponseEntity<Cliente> desativar(@PathVariable Long codigo) {
		Cliente clienteAtualizado = service.desativar(codigo);
		return ResponseEntity.ok(clienteAtualizado);
	}

	@PatchMapping("bloquear/{codigo}")
	public ResponseEntity<Cliente> bloquear(@PathVariable Long codigo) {
		Cliente clienteAtualizado = service.bloquear(codigo);
		return ResponseEntity.ok(clienteAtualizado);
	}

	@PatchMapping("desbloquear/{codigo}")
	public ResponseEntity<Cliente> desbloquear(@PathVariable Long codigo) {
		Cliente clienteAtualizado = service.desbloquear(codigo);
		return ResponseEntity.ok(clienteAtualizado);
	}	

}
