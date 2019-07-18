package br.com.calcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
/***
 * Método main para iniciar a aplicação
 * @param args
 */
@SpringBootApplication
@ComponentScan(basePackages = "br.com.calcard")
public class PropostaBackendApplication extends RepositoryRestConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(PropostaBackendApplication.class, args);
	}
	
}
