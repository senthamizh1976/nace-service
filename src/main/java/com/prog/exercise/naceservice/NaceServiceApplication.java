package com.prog.exercise.naceservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.prog.exercise.naceservice" })
@EntityScan(value = "com.prog.exercise.naceservice")
@EnableJpaAuditing
@EnableJpaRepositories("com.prog.exercise.naceservice")
@OpenAPIDefinition(info = @Info(
		title = "Programming Exercise - NACE Details",
		version = "1.0",
		description = "Programming Exercise - NACE Details"))
public class NaceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaceServiceApplication.class, args);
	}

}
