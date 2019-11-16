package br.com.zenganet.cadastro.service;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericServiceQuery<Entity, Pk, Filtro, Repository extends JpaRepository<Entity, Pk>> {

	@Autowired
	protected Repository repository;

	protected abstract String[] ignoreFields();
	protected abstract boolean isValidaInserir(Entity entity);	
	protected abstract boolean iSValidaAtualizar(Pk pk, Entity entity);
	
	public abstract Page<Entity> pesquisar(Filtro filter, Pageable pageable);

	public Optional<Entity> pesquisar(Pk id) {
		return repository.findById(id);
	}

	public <S extends Entity> S inserir(S entity) {
		if(!isValidaInserir(entity)) {
			//TODO: Implementar exception de inserir com informações ja existentes.
			throw new EmptyResultDataAccessException(1);
		}
		return repository.save(entity);
	}

	public Entity atualizar(Pk pk, Entity entity) {
		Optional<Entity> entitySalva = pesquisar(pk);
		
		if (!entitySalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		
		if(!iSValidaAtualizar(pk, entity)) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(entity, entitySalva.get(), ignoreFields());
		return repository.save(entitySalva.get());
	}

	public void remover(Pk pk) {
		Optional<Entity> entitySalva = pesquisar(pk);
		if (!entitySalva.isPresent()) {
			throw new EmptyResultDataAccessException(1);
		}
		repository.delete(entitySalva.get());
	}

}
