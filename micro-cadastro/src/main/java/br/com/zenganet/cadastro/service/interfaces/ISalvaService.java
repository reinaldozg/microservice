package br.com.zenganet.cadastro.service.interfaces;

public interface ISalvaService<Entity, Pk> {
	<S extends Entity> S inserir(S entity);
	Entity atualizar(Pk pk, Entity entity);
}
