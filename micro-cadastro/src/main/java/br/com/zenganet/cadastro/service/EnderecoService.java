package br.com.zenganet.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.EnderecoRepository;
import br.com.zenganet.core.model.cadastro.Endereco;
import br.com.zenganet.core.model.cadastro.filter.EnderecoFilter;

@Service
public class EnderecoService extends GenericServiceQuery<Endereco, Long, EnderecoFilter, EnderecoRepository> {
	
	@Override
	public Page<Endereco> pesquisar(EnderecoFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidaInserir(Endereco entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Endereco entity) {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
