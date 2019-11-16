package br.com.zenganet.cadastro.service;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.PaisRepository;
import br.com.zenganet.core.model.cadastro.Pais;
import br.com.zenganet.core.model.cadastro.filter.PaisFilter;

@Service
public class PaisService extends GenericServiceQuery<Pais, Long, PaisFilter, PaisRepository> {
	
	@Override
	public Page<Pais> pesquisar(PaisFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		return null;
	}

	@Override
	protected boolean isValidaInserir(Pais entity) {
		return false;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Pais entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Pais> S inserir(S entity) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	@Override
	public Pais atualizar(Long pk, Pais entity) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	@Override
	public void remover(Long pk) {
		throw new NotImplementedException("Operação não permitida!");
	}
	
	
}
