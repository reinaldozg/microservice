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
import br.com.zenganet.core.model.cadastro.Pais;
import br.com.zenganet.core.model.cadastro.filter.PaisFilter;

public class PaisRepositoryImpl implements PesquisaRepositoryQuery<Pais,Integer, PaisFilter>{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Optional<Pais> pesquisar(Integer pk) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pais> criteria = builder.createQuery(Pais.class);
		Root<Pais> root = criteria.from(Pais.class);

		Predicate predicate = builder.equal(root.get("id"), pk);
		criteria.where(predicate);
		
		TypedQuery<Pais> query = manager.createQuery(criteria);
		return query.getResultList().size() == 0 ? Optional.empty() : Optional.of(query.getSingleResult());
	}
	
	@Override
	public Page<Pais> pesquisar(PaisFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pais> criteria = builder.createQuery(Pais.class);
		Root<Pais> root = criteria.from(Pais.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<Pais> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}
	
	private Predicate[] criarRestricoes(PaisFilter filter, CriteriaBuilder builder, Root<Pais> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(filter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")),
					"%" + filter.getNome().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(filter.getSigla())) {
			predicates.add(builder.like(builder.lower(root.get("sigla")),
					"%" + filter.getSigla().toLowerCase() + "%"));
		}
				
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Pais> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(PaisFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Pais> root = criteria.from(Pais.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
