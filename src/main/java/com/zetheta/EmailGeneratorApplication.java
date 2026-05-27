package com.zetheta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmailGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailGeneratorApplication.class, args);
	}

}
