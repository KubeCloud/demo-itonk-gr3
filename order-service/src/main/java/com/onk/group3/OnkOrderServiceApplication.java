package com.onk.group3;

import com.onk.group3.repositories.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnkOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnkOrderServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDb(OrderRepository repository)
	{
		return(args) -> {
			repository.deleteAll();
		};
	}
}
