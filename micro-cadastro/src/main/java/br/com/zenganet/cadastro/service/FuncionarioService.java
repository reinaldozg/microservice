package br.com.zenganet.cadastro.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.FuncionarioRepository;
import br.com.zenganet.core.model.cadastro.Funcionario;
import br.com.zenganet.core.model.cadastro.filter.FuncionarioFilter;

@Service
public class FuncionarioService extends GenericServiceQuery<Funcionario, Long, FuncionarioFilter, FuncionarioRepository> {

	@Override
	public Page<Funcionario> pesquisar(FuncionarioFilter filter, Pageable pageable) {
		return super.repository.pesquisar(filter, pageable);
	}

	@Override
	protected String[] ignoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidaInserir(Funcionario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean iSValidaAtualizar(Long pk, Funcionario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
