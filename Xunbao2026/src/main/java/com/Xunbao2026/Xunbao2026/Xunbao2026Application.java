package com.Xunbao2026.Xunbao2026;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Xunbao2026Application {

	public static void main(String[] args) {
		SpringApplication.run(Xunbao2026Application.class, args);
	}

}
