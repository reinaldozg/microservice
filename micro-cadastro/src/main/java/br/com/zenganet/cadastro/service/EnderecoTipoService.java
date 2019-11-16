package br.com.zenganet.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.EnderecoTipoRepository;
import br.com.zenganet.core.model.cadastro.EnderecoTipo;
import br.com.zenganet.core.model.cadastro.filter.EnderecoTipoFilter;

@Service
public class EnderecoTipoService extends GenericServiceQuery<EnderecoTipo, Long, EnderecoTipoFilter, EnderecoTipoRepository> {
	
	@Override
	public Page<EnderecoTipo> pesquisar(EnderecoTipoFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidaInserir(EnderecoTipo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, EnderecoTipo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
