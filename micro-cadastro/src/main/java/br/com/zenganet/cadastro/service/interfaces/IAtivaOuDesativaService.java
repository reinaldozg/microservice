package br.com.zenganet.cadastro.service.interfaces;

public interface IAtivaOuDesativaService<Entity, Pk> {
	Entity ativar(Pk pk);
	Entity desativar(Pk pk);
}
