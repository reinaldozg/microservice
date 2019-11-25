package br.com.zenganet.cadastro.service.interfaces;

public interface IBloqueiaOuDesbloqueiaService<Entity, Pk> {
	Entity bloquear(Pk pk);
	Entity desbloquear(Pk pk);
}
