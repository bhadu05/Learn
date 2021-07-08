package com.Assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

public class UthAssignmentApplication {

	public static void main(String[] args) {
		System.out.println("I do output things");
		SpringApplication.run(UthAssignmentApplication.class, args);
	}

}
