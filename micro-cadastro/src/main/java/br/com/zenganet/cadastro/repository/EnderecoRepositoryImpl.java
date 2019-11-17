package br.com.zenganet.cadastro.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.zenganet.cadastro.repository.interfaces.PesquisaRepositoryQuery;
import br.com.zenganet.core.model.cadastro.Endereco;
import br.com.zenganet.core.model.cadastro.filter.EnderecoFilter;

public class EnderecoRepositoryImpl implements PesquisaRepositoryQuery<Endereco, Long, EnderecoFilter> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Optional<Endereco> pesquisar(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Endereco> pesquisar(EnderecoFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Endereco> criteria = builder.createQuery(Endereco.class);
		Root<Endereco> root = criteria.from(Endereco.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<Endereco> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}

	private Predicate[] criarRestricoes(EnderecoFilter filter, CriteriaBuilder builder, Root<Endereco> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!StringUtils.isEmpty(filter.getCep())) {
			predicates.add(builder.like(builder.lower(root.get("cep")), "%" + filter.getCep().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getLogradouro())) {
			predicates.add(builder.like(builder.lower(root.get("logradouro")),
					"%" + filter.getLogradouro().toLowerCase() + "%"));
		}

		if (filter.getCidade() != null) {
			predicates.add(builder.equal(root.get("cidade"), filter.getCidade()));
		}

		if (filter.getEnderecoTipo() != null) {
			predicates.add(builder.equal(root.get("enderecoTipo"), filter.getEnderecoTipo()));
		}

		if (filter.getEstado() != null) {
			predicates.add(builder.equal(root.get("estado"), filter.getEstado()));
		}

		predicates.add(builder.equal(root.get("controle").get("excluido"), false));

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Endereco> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(EnderecoFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Endereco> root = criteria.from(Endereco.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
