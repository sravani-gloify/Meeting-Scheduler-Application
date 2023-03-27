package com.jcg.mapstruct;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.jcg.mapstruct")
public class SpringMapstructDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMapstructDemoApplication.class, args);
		log.info("spring boot and mapstruct application");
	}
}
