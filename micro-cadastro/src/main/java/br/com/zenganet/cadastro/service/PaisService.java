package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.PaisRepository;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.core.model.cadastro.Pais;
import br.com.zenganet.core.model.cadastro.filter.PaisFilter;

@Service
public class PaisService implements IPesquisaService<Pais, Integer, PaisFilter> {

	@Autowired
	private PaisRepository repository;

	@Override
	public Page<Pais> pesquisar(PaisFilter filter, Pageable pageable) {
		Page<Pais> pais = repository.pesquisar(filter, pageable);
		if (pais == null || pais.isEmpty()) {throw new EmptyResultDataAccessException(1);}
		return pais;
	}
	
	@Override
	public Optional<Pais> pesquisar(Integer pk) {
		Optional<Pais> pais = repository.pesquisar(pk);
		if (!pais.isPresent()) {throw new EmptyResultDataAccessException(1);}
		return pais;
	}



}