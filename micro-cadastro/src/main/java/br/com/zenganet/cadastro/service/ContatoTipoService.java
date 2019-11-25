package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.ContatoTipoRepository;
import br.com.zenganet.cadastro.service.interfaces.AbstractValidationServiceQuery;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.cadastro.service.interfaces.IRemoveService;
import br.com.zenganet.cadastro.service.interfaces.ISalvaService;
import br.com.zenganet.core.model.cadastro.ContatoTipo;
import br.com.zenganet.core.model.cadastro.filter.ContatoTipoFilter;
import br.com.zenganet.core.utils.DataHoraUtils;

@Service
public class ContatoTipoService extends AbstractValidationServiceQuery<ContatoTipo, Long>
implements IPesquisaService<ContatoTipo, Long, ContatoTipoFilter>, ISalvaService<ContatoTipo, Long>, IRemoveService<Long> {

	@Autowired private ContatoTipoRepository repository;
	
	@Override
	public Page<ContatoTipo> pesquisar(ContatoTipoFilter filter, Pageable pageable) {
		Page<ContatoTipo> contatoTipo = repository.pesquisar(filter, pageable);
		if (contatoTipo == null || contatoTipo.isEmpty()) {throw new EmptyResultDataAccessException(1);}
		return contatoTipo;
	}

	@Override
	public Optional<ContatoTipo> pesquisar(Long pk) {
		Optional<ContatoTipo> contatoTipo = repository.pesquisar(pk);
		if (!contatoTipo.isPresent()) {throw new EmptyResultDataAccessException(1);}
		return contatoTipo;
	}
	
	@Override
	public <S extends ContatoTipo> S inserir(S entity) {
		if (!isValidaInserir(entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}
		entity.getControle().setDataInclusao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(entity);
	}

	@Override
	public ContatoTipo atualizar(Long pk, ContatoTipo entity) {
		Optional<ContatoTipo> contatoTipoSalvo = pesquisar(pk);

		if (!contatoTipoSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		if (!isValidaAtualizar(pk, entity)) {
			throw new NotImplementedException("Implementar exception de validação com informações ja existentes.");
		}

		BeanUtils.copyProperties(entity, contatoTipoSalvo.get(), ignoreFields());
		contatoTipoSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(contatoTipoSalvo.get());
	}

	@Override
	public void remover(Long pk) {
		Optional<ContatoTipo> contatoTipoSalvo = pesquisar(pk);
		if (!contatoTipoSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		contatoTipoSalvo.get().getControle().setExcluido(true);
		repository.save(contatoTipoSalvo.get());
		
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
	protected boolean isValidaAtualizar(Long pk, ContatoTipo entity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
