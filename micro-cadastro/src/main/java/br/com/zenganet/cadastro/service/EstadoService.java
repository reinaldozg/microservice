package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.EstadoRepository;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.core.model.cadastro.Estado;
import br.com.zenganet.core.model.cadastro.filter.EstadoFilter;

@Service
public class EstadoService implements IPesquisaService<Estado, Integer, EstadoFilter> {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public Optional<Estado> pesquisar(Integer pk) {
		return estadoRepository.pesquisar(pk);
	}

	@Override
	public Page<Estado> pesquisar(EstadoFilter filter, Pageable pageable) {
		return estadoRepository.pesquisar(filter, pageable);
	}
}
