package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.EnderecoTipoRepository;
import br.com.zenganet.cadastro.service.interfaces.AbstractValidationServiceQuery;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.cadastro.service.interfaces.IRemoveService;
import br.com.zenganet.cadastro.service.interfaces.ISalvaService;
import br.com.zenganet.core.model.cadastro.EnderecoTipo;
import br.com.zenganet.core.model.cadastro.filter.EnderecoTipoFilter;
import br.com.zenganet.core.utils.DataHoraUtils;

@Service
public class EnderecoTipoService extends AbstractValidationServiceQuery<EnderecoTipo, Long>
		implements IPesquisaService<EnderecoTipo, Long, EnderecoTipoFilter>, ISalvaService<EnderecoTipo, Long>,
		IRemoveService<Long> {

	@Autowired private EnderecoTipoRepository repository;
	
	@Override
	public Page<EnderecoTipo> pesquisar(EnderecoTipoFilter filter, Pageable pageable) {
		Page<EnderecoTipo> enderecoTipo = repository.pesquisar(filter, pageable);
		if (enderecoTipo == null || enderecoTipo.isEmpty()) {throw new EmptyResultDataAccessException(1);}
		return enderecoTipo;
	}

	@Override
	public Optional<EnderecoTipo> pesquisar(Long pk) {
		Optional<EnderecoTipo> enderecoTipo = repository.pesquisar(pk);
		if (!enderecoTipo.isPresent()) {throw new EmptyResultDataAccessException(1);}
		return enderecoTipo;
	}

	@Override
	public <S extends EnderecoTipo> S inserir(S entity) {
		if (!isValidaInserir(entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}
		entity.getControle().setDataInclusao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(entity);
	}

	@Override
	public EnderecoTipo atualizar(Long pk, EnderecoTipo entity) {
		Optional<EnderecoTipo> enderecoTipoSalvo = pesquisar(pk);

		if (!enderecoTipoSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		if (!isValidaAtualizar(pk, entity)) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(entity, enderecoTipoSalvo.get(), ignoreFields());
		enderecoTipoSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(enderecoTipoSalvo.get());
	}

	@Override
	public void remover(Long pk) {
		Optional<EnderecoTipo> enderecoTipoSalvo = pesquisar(pk);
		if (!enderecoTipoSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		enderecoTipoSalvo.get().getControle().setExcluido(true);
		repository.save(enderecoTipoSalvo.get());
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
	protected boolean isValidaAtualizar(Long pk, EnderecoTipo entity) {
		// TODO Auto-generated method stub
		return false;
	}

}
