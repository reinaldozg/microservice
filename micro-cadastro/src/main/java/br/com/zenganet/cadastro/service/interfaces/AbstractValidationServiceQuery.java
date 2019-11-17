package br.com.zenganet.cadastro.service.interfaces;

public abstract class AbstractValidationServiceQuery<Entity, Pk> {
	protected abstract String[] ignoreFields();
	protected abstract boolean isValidaInserir(Entity entity);	
	protected abstract boolean isValidaAtualizar(Pk pk, Entity entity);
}
