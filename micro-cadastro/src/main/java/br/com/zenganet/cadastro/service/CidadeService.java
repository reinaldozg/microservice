package br.com.zenganet.cadastro.service;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.CidadeRepository;
import br.com.zenganet.core.model.cadastro.Cidade;
import br.com.zenganet.core.model.cadastro.filter.CidadeFilter;

@Service
public class CidadeService extends GenericServiceQuery<Cidade, Long, CidadeFilter, CidadeRepository> {
	
	@Override
	public Page<Cidade> pesquisar(CidadeFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		return null;
	}

	@Override
	protected boolean isValidaInserir(Cidade entity) {
		return false;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Cidade entity) {
		return false;
	}

	@Override
	public <S extends Cidade> S inserir(S entity) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	@Override
	public Cidade atualizar(Long pk, Cidade entity) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	@Override
	public void remover(Long pk) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	
}
