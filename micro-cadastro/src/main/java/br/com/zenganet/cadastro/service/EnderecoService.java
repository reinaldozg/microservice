package br.com.zenganet.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zenganet.cadastro.repository.EnderecoRepository;
import br.com.zenganet.cadastro.service.interfaces.IPesquisaService;
import br.com.zenganet.core.model.cadastro.Endereco;
import br.com.zenganet.core.model.cadastro.filter.EnderecoFilter;

@Service
public class EnderecoService implements IPesquisaService<Endereco, Long, EnderecoFilter> {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Page<Endereco> pesquisar(EnderecoFilter filter, Pageable pageable) {
		return enderecoRepository.pesquisar(filter, pageable);
	}

	@Override
	public Optional<Endereco> pesquisar(Long pk) {
		return enderecoRepository.pesquisar(pk);
	}


	
}
