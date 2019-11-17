package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.FuncionarioRepository;
import br.com.zenganet.cadastro.service.interfaces.AbstractValidationServiceQuery;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.cadastro.service.interfaces.IRemoveService;
import br.com.zenganet.cadastro.service.interfaces.ISalvaService;
import br.com.zenganet.core.model.cadastro.Funcionario;
import br.com.zenganet.core.model.cadastro.filter.FuncionarioFilter;
import br.com.zenganet.core.utils.DataHoraUtils;


@Service
public class FuncionarioService extends AbstractValidationServiceQuery<Funcionario, Long> implements
		IPesquisaService<Funcionario, Long, FuncionarioFilter>, ISalvaService<Funcionario, Long>, IRemoveService<Long> {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Page<Funcionario> pesquisar(FuncionarioFilter filter, Pageable pageable) {
		return funcionarioRepository.pesquisar(filter, pageable);
	}

	@Override
	public Optional<Funcionario> pesquisar(Long pk) {
		return funcionarioRepository.pesquisar(pk);
	}

	@Override
	public <S extends Funcionario> S inserir(S entity) {
		if (!isValidaInserir(entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}
		entity.getControle().setDataInclusao(DataHoraUtils.getCalendarInstanceBrasil());
		return funcionarioRepository.save(entity);
	}

	@Override
	public Funcionario atualizar(Long pk, Funcionario entity) {

		Optional<Funcionario> funcionarioSalvo = pesquisar(pk);

		if (!funcionarioSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		if (!isValidaAtualizar(pk, entity)) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(entity, funcionarioSalvo.get(), ignoreFields());
		funcionarioSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return funcionarioRepository.save(funcionarioSalvo.get());
	}

	@Override
	public void remover(Long pk) {
		Optional<Funcionario> funcionarioSalvo = pesquisar(pk);
		if (!funcionarioSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		funcionarioSalvo.get().getControle().setExcluido(true);
		funcionarioRepository.save(funcionarioSalvo.get());
	}

	@Override
	protected String[] ignoreFields() {
		String[] fields = { "id", "controle.excluido", "dataInclusao" };
		return fields;
	}

	@Override
	protected boolean isValidaInserir(Funcionario entity) {
// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isValidaAtualizar(Long pk, Funcionario entity) {
// TODO Auto-generated method stub
		return true;
	}
}
