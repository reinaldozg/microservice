package br.com.zenganet.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.ClienteRepository;
import br.com.zenganet.core.model.cadastro.Cliente;
import br.com.zenganet.core.model.cadastro.filter.ClienteFilter;

@Service
public class ClienteService extends GenericServiceQuery<Cliente, Long, ClienteFilter, ClienteRepository> {

	@Override
	public Page<Cliente> pesquisar(ClienteFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		String[] fields = { "id", "excluido" };
		return fields;
	}

	@Override
	protected boolean isValidaInserir(Cliente entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Cliente entity) {
		// TODO Auto-generated method stub
		return true;
	}

}
