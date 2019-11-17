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
import br.com.zenganet.core.model.cadastro.Funcionario;
import br.com.zenganet.core.model.cadastro.filter.FuncionarioFilter;

public class FuncionarioRepositoryImpl implements PesquisaRepositoryQuery<Funcionario, Long, FuncionarioFilter> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Optional<Funcionario> pesquisar(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Funcionario> pesquisar(FuncionarioFilter filter, Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Funcionario> criteria = builder.createQuery(Funcionario.class);
		Root<Funcionario> root = criteria.from(Funcionario.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		TypedQuery<Funcionario> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		return new PageImpl<>(query.getResultList(), pageable, total(filter));
	}

	private Predicate[] criarRestricoes(FuncionarioFilter filter, CriteriaBuilder builder, Root<Funcionario> root) {
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

		if (!StringUtils.isEmpty(filter.getCargo())) {
			predicates.add(builder.like(builder.lower(root.get("cargo")), "%" + filter.getCargo().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getMatricula())) {
			predicates.add(builder.like(builder.lower(root.get("matricula")),
					"%" + filter.getMatricula().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getCpts())) {
			predicates.add(builder.like(builder.lower(root.get("cpts")), "%" + filter.getCpts().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getCptsSerie())) {
			predicates.add(builder.like(builder.lower(root.get("cptsSerie")),
					"%" + filter.getCptsSerie().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getDemissaoMotivo())) {
			predicates.add(builder.like(builder.lower(root.get("demissaoMotivo")),
					"%" + filter.getDemissaoMotivo().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getTituloInscricao())) {
			predicates.add(builder.like(builder.lower(root.get("tituloInscricao")),
					"%" + filter.getTituloInscricao().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getPis())) {
			predicates.add(builder.like(builder.lower(root.get("pis")), "%" + filter.getPis().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(filter.getReservistaRa())) {
			predicates.add(builder.like(builder.lower(root.get("reservistaRa")),
					"%" + filter.getReservistaRa().toLowerCase() + "%"));
		}

		predicates.add(builder.equal(root.get("controle").get("excluido"), false));

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<Funcionario> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total(FuncionarioFilter filter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Funcionario> root = criteria.from(Funcionario.class);
		Predicate[] predicates = criarRestricoes(filter, builder, root);
		criteria.where(predicates);
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

}
