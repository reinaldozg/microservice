package br.com.zenganet.cadastro.resource.interfaces;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;



public interface ISalvaResource<Entity, Pk> {
	
	ResponseEntity<Entity> inserir(@Valid @RequestBody Entity entity, BindingResult result, HttpServletResponse response);
	ResponseEntity<Entity> atualizar(@PathVariable Pk codigo, @Valid @RequestBody Entity entity, BindingResult result,  HttpServletResponse response);

}
