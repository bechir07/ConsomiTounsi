package tn.esprit.spring;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@Import(springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class)
@OpenAPIDefinition(
	    info = @Info(
	        title = "Consomi Tonsi",
	        version = "2.0"
	    )
	)
public class ConsomiTounsiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConsomiTounsiApplication.class, args);
		}

	
}
