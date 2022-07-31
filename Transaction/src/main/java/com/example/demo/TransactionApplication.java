package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}
	//docker image build -t transaction .
	//docker container run --name transaction -p 8083:8083 -d transaction
	//docker container logs transaction
	//docker images transaction
}
