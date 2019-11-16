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

import br.com.zenganet.cadastro.service.FuncionarioService;
import br.com.zenganet.core.model.cadastro.Funcionario;
import br.com.zenganet.core.model.cadastro.filter.FuncionarioFilter;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Funcionario> pesquisar(@PathVariable Long codigo) {
		Optional<Funcionario> funcionario = funcionarioService.pesquisar(codigo);
		return funcionario.isPresent() ? ResponseEntity.ok(funcionario.get()) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<Funcionario>> pesquisar(FuncionarioFilter filtro, Pageable pageable) {
		Page<Funcionario> funcionarios = funcionarioService.pesquisar(filtro, pageable);
		return funcionarios.getTotalElements() > 0 ? ResponseEntity.ok(funcionarios) : ResponseEntity.notFound().build();
	}
	
	@PostMapping	
	public ResponseEntity<Funcionario> inserir(@Valid @RequestBody Funcionario funcionario, HttpServletResponse response) {
		Funcionario entitySalvo = funcionarioService.inserir(funcionario);		
		return ResponseEntity.status(HttpStatus.CREATED).body(entitySalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long codigo, @Valid @RequestBody Funcionario funcionario,	HttpServletResponse response) {
		Funcionario funcionarioAtualizado = funcionarioService.atualizar(codigo, funcionario);
		return ResponseEntity.ok(funcionarioAtualizado);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		funcionarioService.remover(codigo);
	}
	
}
