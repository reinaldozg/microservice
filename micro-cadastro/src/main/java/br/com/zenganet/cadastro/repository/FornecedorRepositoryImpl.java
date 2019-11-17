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
import br.com.zenganet.core.model.cadastro.Fornecedor;
import br.com.zenganet.core.model.cadastro.filter.FornecedorFilter;

public class FornecedorRepositoryImpl implements PesquisaRepositoryQuery<Fornecedor,Long, FornecedorFilter>{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Optional<Fornecedor> pesquisar(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Page<Fornecedor> pesquisar(FornecedorFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Fornecedor> criteria = builder.createQuery(Fornecedor.class);
		Root<Fornecedor> root = criteria.from(Fornecedor.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<Fornecedor> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}
	
	private Predicate[] criarRestricoes(FornecedorFilter filter, CriteriaBuilder builder, Root<Fornecedor> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if (!StringUtils.isEmpty(filter.getCnpjOuCpf())) {
			predicates.add(builder.like(builder.lower(root.get("cnpjOuCpf")),
					"%" + filter.getCnpjOuCpf().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getInscEstadualOuEstCivil())) {
			predicates.add(builder.like(builder.lower(root.get("inscEstadualOuEstCivil")),
					"%" + filter.getInscEstadualOuEstCivil().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getInscMunicipalOuRg())) {
			predicates.add(builder.like(builder.lower(root.get("inscMunicipalOuRg")),
					"%" + filter.getInscMunicipalOuRg().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getNomeFantasiaOuSexo())) {
			predicates.add(builder.like(builder.lower(root.get("nomeFantasiaOuSexo")),
					"%" + filter.getNomeFantasiaOuSexo().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getNomeOuRazaoSocial())) {
			predicates.add(builder.like(builder.lower(root.get("nomeOuRazaoSocial")),
					"%" + filter.getNomeOuRazaoSocial().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(filter.getCodigoRural())) {
			predicates.add(builder.like(builder.lower(root.get("codigoRural")),
					"%" + filter.getCodigoRural().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(filter.getResponsavel())) {
			predicates.add(builder.like(builder.lower(root.get("responsavel")),
					"%" + filter.getResponsavel().toLowerCase() + "%"));
		}
		
		if (filter.isFabricante()) {
			predicates.add(builder.equal(root.get("fabricante"), filter.isFabricante()));
		}
		
		predicates.add(builder.equal(root.get("controle").get("excluido"), false));
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Fornecedor> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(FornecedorFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Fornecedor> root = criteria.from(Fornecedor.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
