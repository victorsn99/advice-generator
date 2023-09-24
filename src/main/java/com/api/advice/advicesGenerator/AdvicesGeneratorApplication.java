package com.api.advice.advicesGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AdvicesGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvicesGeneratorApplication.class, args);
	}

}
