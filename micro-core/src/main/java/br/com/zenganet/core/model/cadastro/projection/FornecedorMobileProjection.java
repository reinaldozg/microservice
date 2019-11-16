package br.com.zenganet.core.model.cadastro.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import br.com.zenganet.core.model.cadastro.Fornecedor;

@Projection( name = "mobile", types = { Fornecedor.class}) 
public interface FornecedorMobileProjection extends PessoaMobileProjection {

	@Value("#{target.codigoRural}")
	String getCodigoRural();

	@Value("#{target.fabricante}")
	boolean isFabricante();

}