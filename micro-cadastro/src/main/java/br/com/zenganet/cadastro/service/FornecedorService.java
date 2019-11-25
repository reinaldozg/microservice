package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.FornecedorRepository;
import br.com.zenganet.cadastro.service.interfaces.AbstractValidationServiceQuery;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.cadastro.service.interfaces.IRemoveService;
import br.com.zenganet.cadastro.service.interfaces.ISalvaService;
import br.com.zenganet.core.model.cadastro.Fornecedor;
import br.com.zenganet.core.model.cadastro.filter.FornecedorFilter;
import br.com.zenganet.core.utils.DataHoraUtils;

@Service
public class FornecedorService extends AbstractValidationServiceQuery<Fornecedor, Long> implements
		IPesquisaService<Fornecedor, Long, FornecedorFilter>, ISalvaService<Fornecedor, Long>, IRemoveService<Long> {

	@Autowired
	private FornecedorRepository repository;

	@Override
	public Page<Fornecedor> pesquisar(FornecedorFilter filter, Pageable pageable) {
		Page<Fornecedor> fornecedor = repository.pesquisar(filter, pageable);
		if (fornecedor == null || fornecedor.isEmpty()) {throw new EmptyResultDataAccessException(1);}
		return fornecedor;
	}

	@Override
	public Optional<Fornecedor> pesquisar(Long pk) {
		Optional<Fornecedor> fornecedor = repository.pesquisar(pk);
		if (!fornecedor.isPresent()) {throw new EmptyResultDataAccessException(1);}
		return fornecedor;
	}

	@Override
	public <S extends Fornecedor> S inserir(S entity) {
		if (!isValidaInserir(entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}
		entity.getControle().setDataInclusao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(entity);
	}

	@Override
	public Fornecedor atualizar(Long pk, Fornecedor entity) {

		Optional<Fornecedor> fornecedorSalvo = pesquisar(pk);

		if (!fornecedorSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		if (!isValidaAtualizar(pk, entity)) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(entity, fornecedorSalvo.get(), ignoreFields());
		fornecedorSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(fornecedorSalvo.get());
	}

	@Override
	public void remover(Long pk) {
		Optional<Fornecedor> fornecedorSalvo = pesquisar(pk);
		if (!fornecedorSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		fornecedorSalvo.get().getControle().setExcluido(true);
		repository.save(fornecedorSalvo.get());
	}

	@Override
	protected String[] ignoreFields() {
		String[] fields = { "id", "controle.excluido", "dataInclusao" };
		return fields;
	}

	@Override
	protected boolean isValidaInserir(Fornecedor entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isValidaAtualizar(Long pk, Fornecedor entity) {
		// TODO Auto-generated method stub
		return true;
	}
}
