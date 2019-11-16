package br.com.zenganet.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.zenganet.core.model")
public class MicroCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroCadastroApplication.class, args);
	}

}
