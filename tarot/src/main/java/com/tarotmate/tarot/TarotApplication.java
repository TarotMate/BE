package com.tarotmate.tarot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(exclude = DataSourceAuthConfiguration.class)
public class TarotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarotApplication.class, args);
	}

}
