package br.com.willyan.seplag.lotacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("br.com.willyan.seplag.lotacao.propertie")
public class LotacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LotacaoApplication.class, args);
	}

}
