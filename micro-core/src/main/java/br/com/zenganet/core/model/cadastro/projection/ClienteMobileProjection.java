package br.com.zenganet.core.model.cadastro.projection;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import br.com.zenganet.core.model.cadastro.Cliente;

@Projection( name = "mobile", types = { Cliente.class}) 
public interface ClienteMobileProjection extends PessoaMobileProjection{
		
	@Value("#{target.limiteCompras}")
	BigDecimal getLimiteCompras();
	
	@Value("#{target.bloqueado}")
	boolean isBloqueado();
	
	@Value("#{target.observacao}")
	String getObservacao();
	
}
