package br.com.zenganet.core.model.cadastro.projection;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import br.com.zenganet.core.model.cadastro.Funcionario;

@Projection( name = "mobile", types = {Funcionario.class }) 
public interface FuncionarioMobileProjection extends PessoaMobileProjection{

	@Value("#{target.matricula}")
	String getMatricula();
	
	@Value("#{target.dataAdmissao}")
	Calendar getDataAdmissao();

}
