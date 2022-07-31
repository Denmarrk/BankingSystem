package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAccountApplication.class, args);
	}
	//docker image build -t useraccount .
	//docker container run --name useraccount -p 8080:8080 -d useraccount
	//docker container logs useraccount
	//docker images useraccount
}
