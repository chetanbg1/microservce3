package com.gfarm.adressService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class AdressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdressServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getmoModelMapper(){
		return new ModelMapper();
	}
}
