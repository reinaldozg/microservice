package br.com.zenganet.cadastro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.ClienteRepository;
import br.com.zenganet.cadastro.service.interfaces.AbstractValidationServiceQuery;
import br.com.zenganet.cadastro.service.interfaces.IAtivaOuDesativaService;
import br.com.zenganet.cadastro.service.interfaces.IBloqueiaOuDesbloqueiaService;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.cadastro.service.interfaces.IRemoveService;
import br.com.zenganet.cadastro.service.interfaces.ISalvaService;
import br.com.zenganet.core.model.cadastro.Cliente;
import br.com.zenganet.core.model.cadastro.filter.ClienteFilter;
import br.com.zenganet.core.utils.DataHoraUtils;

@Service
public class ClienteService extends AbstractValidationServiceQuery<Cliente, Long>
		implements 
			IPesquisaService<Cliente, Long, ClienteFilter>, 
			ISalvaService<Cliente, Long>, 
			IRemoveService<Long>,
			IAtivaOuDesativaService<Cliente, Long>,
			IBloqueiaOuDesbloqueiaService<Cliente, Long>{

	@Autowired
	private ClienteRepository repository;

	@Override
	public Page<Cliente> pesquisar(ClienteFilter filter, Pageable pageable) {
		Page<Cliente> clientes = repository.pesquisar(filter, pageable);
		if (clientes == null || clientes.isEmpty()) {throw new EmptyResultDataAccessException(1);}
		return clientes;
	}

	@Override
	public Optional<Cliente> pesquisar(Long pk) {
		Optional<Cliente> cliente = repository.pesquisar(pk);
		if (!cliente.isPresent()) {throw new EmptyResultDataAccessException(1);}
		return cliente;
	}

	@Override
	public <S extends Cliente> S inserir(S entity) {
		if (!isValidaInserir(entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}
		entity.getControle().setDataInclusao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(entity);
	}

	@Override
	public Cliente atualizar(Long pk, Cliente entity) {
		
		Optional<Cliente> clienteSalvo = pesquisar(pk);

		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		if (!isValidaAtualizar(pk, entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}

		BeanUtils.copyProperties(entity, clienteSalvo.get(), ignoreFields());
		clienteSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(clienteSalvo.get());
	}

	@Override
	public void remover(Long pk) {
		Optional<Cliente> clienteSalvo = pesquisar(pk);
		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		clienteSalvo.get().getControle().setExcluido(true);
		repository.save(clienteSalvo.get());
	}
	
	@Override
	public Cliente bloquear(Long pk) {
		Optional<Cliente> clienteSalvo = pesquisar(pk);		
		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}		
		clienteSalvo.get().setBloqueado(true);		
		clienteSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(clienteSalvo.get());
	}

	@Override
	public Cliente desbloquear(Long pk) {
		Optional<Cliente> clienteSalvo = pesquisar(pk);		
		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}		
		clienteSalvo.get().setBloqueado(false);		
		clienteSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(clienteSalvo.get());
	}

	@Override
	public Cliente ativar(Long pk) {
		Optional<Cliente> clienteSalvo = pesquisar(pk);		
		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}		
		clienteSalvo.get().getControle().setAtivo(true);
		clienteSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(clienteSalvo.get());
	}

	@Override
	public Cliente desativar(Long pk) {
		Optional<Cliente> clienteSalvo = pesquisar(pk);		
		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}		
		clienteSalvo.get().getControle().setAtivo(false);	
		clienteSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return repository.save(clienteSalvo.get());
	}
	
	@Override
	protected String[] ignoreFields() {
		List<String> fields = new ArrayList<String>();
		fields.add("id");
		fields.add("controle");	
		fields.add("pessoaTipo");			
		return fields.toArray(new String[fields.size()]);
	}

	@Override
	protected boolean isValidaInserir(Cliente entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected boolean isValidaAtualizar(Long pk, Cliente entity) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
