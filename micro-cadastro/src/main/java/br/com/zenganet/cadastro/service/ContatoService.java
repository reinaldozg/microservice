package br.com.zenganet.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.ContatoRepository;
import br.com.zenganet.core.model.cadastro.Contato;
import br.com.zenganet.core.model.cadastro.filter.ContatoFilter;

@Service
public class ContatoService extends GenericServiceQuery<Contato, Long, ContatoFilter, ContatoRepository> {
	
	@Override
	public Page<Contato> pesquisar(ContatoFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidaInserir(Contato entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Contato entity) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
