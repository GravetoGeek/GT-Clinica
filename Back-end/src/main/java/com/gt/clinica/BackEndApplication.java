package com.gt.clinica;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
		String data = "1989-06-11";
		LocalDate nova = LocalDate.parse(data);
		System.out.println(nova);
		System.out.println(nova.getClass());
	}

}
