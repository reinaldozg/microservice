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
import br.com.zenganet.core.model.cadastro.Cliente;
import br.com.zenganet.core.model.cadastro.filter.ClienteFilter;

public class ClienteRepositoryImpl implements PesquisaRepositoryQuery<Cliente, Long, ClienteFilter> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Optional<Cliente> pesquisar(Long pk) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		predicates.add(builder.equal(root.get("id"), pk));
		predicates.add(builder.equal(root.get("controle").get("excluido"), false));

		criteria.where(predicates.toArray(new Predicate[predicates.size()]));
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		return query.getResultList().size() == 0 ? Optional.empty() : Optional.of(query.getSingleResult());
	}

	@Override
	public Page<Cliente> pesquisar(ClienteFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<Cliente> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}

	private Predicate[] criarRestricoes(ClienteFilter filter, CriteriaBuilder builder, Root<Cliente> root) {
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

		predicates.add(builder.equal(root.get("controle").get("excluido"), false));

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Cliente> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(ClienteFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Cliente> root = criteria.from(Cliente.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
