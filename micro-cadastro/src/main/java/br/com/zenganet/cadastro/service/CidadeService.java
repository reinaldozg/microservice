package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.CidadeRepository;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.core.model.cadastro.Cidade;
import br.com.zenganet.core.model.cadastro.filter.CidadeFilter;

@Service
public class CidadeService implements IPesquisaService<Cidade, Integer, CidadeFilter> {

	@Autowired
	private CidadeRepository repository;

	@Override
	public Optional<Cidade> pesquisar(Integer pk) {
		Optional<Cidade> cidade = repository.pesquisar(pk);
		if (!cidade.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cidade;
	}

	@Override
	public Page<Cidade> pesquisar(CidadeFilter filter, Pageable pageable) {
		Page<Cidade> cidades = repository.pesquisar(filter, pageable);
		if (cidades == null || cidades.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cidades;
	}

}
