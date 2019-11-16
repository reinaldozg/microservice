package br.com.zenganet.core.model.cadastro.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import br.com.zenganet.core.model.cadastro.Pessoa;
import br.com.zenganet.core.model.cadastro.PessoaTipo;

@Projection( name = "mobile", types = {Pessoa.class }) 
public interface PessoaMobileProjection {

	@Value("#{target.tipo}")
	PessoaTipo getTipo();
	
	@Value("#{target.cnpjOuCpf}")
	String getCnpjOuCpf();
	
	@Value("#{target.nomeOuRazaoSocial}")
	String getNomeOuRazaoSocial();
}