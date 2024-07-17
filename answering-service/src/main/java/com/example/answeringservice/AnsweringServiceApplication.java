package com.example.answeringservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class AnsweringServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnsweringServiceApplication.class, args);
	}

}
