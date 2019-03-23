package com.poli.online_sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnlineSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineSaleApplication.class, args);
	}

}
