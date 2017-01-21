package br.com.valemobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class ValemobiAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ValemobiAppApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ValemobiAppApplication.class);
	}

	
}
