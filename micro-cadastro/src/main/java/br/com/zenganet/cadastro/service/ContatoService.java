package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.ContatoRepository;
import br.com.zenganet.cadastro.service.interfaces.AbstractValidationServiceQuery;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.cadastro.service.interfaces.IRemoveService;
import br.com.zenganet.cadastro.service.interfaces.ISalvaService;
import br.com.zenganet.core.model.cadastro.Contato;
import br.com.zenganet.core.model.cadastro.filter.ContatoFilter;
import br.com.zenganet.core.utils.DataHoraUtils;

@Service
public class ContatoService extends AbstractValidationServiceQuery<Contato, Long> 
implements IPesquisaService<Contato, Long, ContatoFilter>, ISalvaService<Contato, Long>, IRemoveService<Long>{

	@Autowired private ContatoRepository repository;
	
	@Override
	public Page<Contato> pesquisar(ContatoFilter filter, Pageable pageable) {
		Page<Contato> contato = repository.pesquisar(filter, pageable);
		if (contato == null || contato.isEmpty()) {throw new EmptyResultDataAccessException(1);}
		return contato;
	}

	@Override
	public Optional<Contato> pesquisar(Long pk) {
		Optional<Contato> contato = repository.pesquisar(pk);
		if (!contato.isPresent()) {throw new EmptyResultDataAccessException(1);}
		return contato;
	}
	
	@Override
	public <S extends Contato> S inserir(S entity) {
		if (!isValidaInserir(entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}
		entity.getControle().setDataInclusao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(entity);
	}

	@Override
	public Contato atualizar(Long pk, Contato entity) {
		Optional<Contato> contatoSalvo = pesquisar(pk);
		if (!contatoSalvo.isPresent()) {throw new EmptyResultDataAccessException(1);}
		if (!isValidaAtualizar(pk, entity)) {throw new EmptyResultDataAccessException(1);}
		BeanUtils.copyProperties(entity, contatoSalvo.get(), ignoreFields());
		contatoSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(contatoSalvo.get());
	}	
	
	@Override
	public void remover(Long pk) {
		Optional<Contato> contatoSalvo = pesquisar(pk);
		if (!contatoSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		contatoSalvo.get().getControle().setExcluido(true);
		repository.save(contatoSalvo.get());
		
	}
	
	@Override
	protected String[] ignoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isValidaInserir(Contato entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isValidaAtualizar(Long pk, Contato entity) {
		// TODO Auto-generated method stub
		return false;
	}


}
