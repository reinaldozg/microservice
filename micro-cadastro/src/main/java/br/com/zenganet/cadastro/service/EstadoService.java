package br.com.zenganet.cadastro.service;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.EstadoRepository;
import br.com.zenganet.core.model.cadastro.Estado;
import br.com.zenganet.core.model.cadastro.filter.EstadoFilter;

@Service
public class EstadoService extends GenericServiceQuery<Estado, Long, EstadoFilter, EstadoRepository> {
	
	@Override
	public Page<Estado> pesquisar(EstadoFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		return null;
	}

	@Override
	protected boolean isValidaInserir(Estado entity) {
		return false;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Estado entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Estado> S inserir(S entity) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	@Override
	public Estado atualizar(Long pk, Estado entity) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	@Override
	public void remover(Long pk) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	
}
