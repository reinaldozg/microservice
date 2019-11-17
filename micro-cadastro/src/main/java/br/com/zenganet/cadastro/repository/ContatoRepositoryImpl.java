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
import br.com.zenganet.core.model.cadastro.Contato;
import br.com.zenganet.core.model.cadastro.filter.ContatoFilter;

public class ContatoRepositoryImpl implements PesquisaRepositoryQuery<Contato,Long, ContatoFilter>{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Optional<Contato> pesquisar(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<Contato> pesquisar(ContatoFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Contato> criteria = builder.createQuery(Contato.class);
		Root<Contato> root = criteria.from(Contato.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<Contato> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}
	
	private Predicate[] criarRestricoes(ContatoFilter filter, CriteriaBuilder builder, Root<Contato> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
				
		if (!StringUtils.isEmpty(filter.getContato())) {
			predicates.add(builder.like(builder.lower(root.get("contato")),
					"%" + filter.getContato().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(filter.getContatoTipo())) {
			predicates.add(builder.like(builder.lower(root.get("contatoTipo")),
					"%" + filter.getContatoTipo().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(filter.getNome())) {
			predicates.add(builder.like(builder.lower(root.get("nome")),
					"%" + filter.getNome().toLowerCase() + "%"));
		}
		
		if (filter.isPrincipal()) {
			predicates.add(builder.equal(root.get("principal"), filter.isPrincipal()));
		}
					
		predicates.add(builder.equal(root.get("controle").get("excluido"), false));
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Contato> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(ContatoFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Contato> root = criteria.from(Contato.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
