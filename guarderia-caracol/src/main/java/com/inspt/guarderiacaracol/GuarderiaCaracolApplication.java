package com.inspt.guarderiacaracol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.inspt.guarderiacaracol.repository.CustomRepository;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepository.class)
public class GuarderiaCaracolApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuarderiaCaracolApplication.class, args);
	}
}
