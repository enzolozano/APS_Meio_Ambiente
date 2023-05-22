package com.aps.aps;

import java.util.TimeZone;

import jakarta.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ApsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApsApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault((TimeZone.getTimeZone("America/Sao_Paulo")));
	}

}
