package br.com.zenganet.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.FornecedorRepository;
import br.com.zenganet.core.model.cadastro.Fornecedor;
import br.com.zenganet.core.model.cadastro.filter.FornecedorFilter;

@Service
public class FornecedorService extends GenericServiceQuery<Fornecedor, Long, FornecedorFilter, FornecedorRepository> {

	@Override
	public Page<Fornecedor> pesquisar(FornecedorFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidaInserir(Fornecedor entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Fornecedor entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
