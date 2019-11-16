package br.com.zenganet.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.ContatoTipoRepository;
import br.com.zenganet.core.model.cadastro.ContatoTipo;
import br.com.zenganet.core.model.cadastro.filter.ContatoTipoFilter;

@Service
public class ContatoTipoService extends GenericServiceQuery<ContatoTipo, Long, ContatoTipoFilter, ContatoTipoRepository> {
	
	@Override
	public Page<ContatoTipo> pesquisar(ContatoTipoFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidaInserir(ContatoTipo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, ContatoTipo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
