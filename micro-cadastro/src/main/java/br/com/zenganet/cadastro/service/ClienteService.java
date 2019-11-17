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
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.cadastro.service.interfaces.IRemoveService;
import br.com.zenganet.cadastro.service.interfaces.ISalvaService;
import br.com.zenganet.core.model.cadastro.Cliente;
import br.com.zenganet.core.model.cadastro.filter.ClienteFilter;
import br.com.zenganet.core.utils.DataHoraUtils;

@Service
public class ClienteService extends AbstractValidationServiceQuery<Cliente, Long>
		implements IPesquisaService<Cliente, Long, ClienteFilter>, ISalvaService<Cliente, Long>, IRemoveService<Long> {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Page<Cliente> pesquisar(ClienteFilter filter, Pageable pageable) {
		return clienteRepository.pesquisar(filter, pageable);
	}

	@Override
	public Optional<Cliente> pesquisar(Long pk) {
		return clienteRepository.pesquisar(pk);
	}

	@Override
	public <S extends Cliente> S inserir(S entity) {
		if (!isValidaInserir(entity)) {
			throw new NotImplementedException("Implementar exception de inserir com informações ja existentes.");
		}
		entity.getControle().setDataInclusao(DataHoraUtils.getCalendarInstanceBrasil());
		return clienteRepository.save(entity);
	}

	@Override
	public Cliente atualizar(Long pk, Cliente entity) {
		
		Optional<Cliente> clienteSalvo = pesquisar(pk);

		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}

		if (!isValidaAtualizar(pk, entity)) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(entity, clienteSalvo.get(), ignoreFields());
		clienteSalvo.get().getControle().setUltimaAtualizacao(DataHoraUtils.getCalendarInstanceBrasil());
		return clienteRepository.save(clienteSalvo.get());
	}

	@Override
	public void remover(Long pk) {
		Optional<Cliente> clienteSalvo = pesquisar(pk);
		if (!clienteSalvo.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		clienteSalvo.get().getControle().setExcluido(true);
		clienteRepository.save(clienteSalvo.get());
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
