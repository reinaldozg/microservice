package br.com.zenganet.cadastro.resource.interfaces;

import org.springframework.web.bind.annotation.PathVariable;

public interface IRemoveResource<Pk> {
	void remover(@PathVariable Pk codigo);
}
