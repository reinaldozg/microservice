package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private PaisRepository paisRepository;

	@Override
	public Optional<Pais> pesquisar(Integer pk) {
		return paisRepository.pesquisar(pk);
	}

	@Override
	public Page<Pais> pesquisar(PaisFilter filter, Pageable pageable) {
		return paisRepository.pesquisar(filter, pageable);
	}

}