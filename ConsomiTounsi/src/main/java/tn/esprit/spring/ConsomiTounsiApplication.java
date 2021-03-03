package tn.esprit.spring;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
//@EnableSwagger2
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
