package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		//System.out.print("dsadas");
	}
//docker image build -t login .
	//docker container run --name loginfile -p 8081:8081 -d login
//docker container logs loginfile
	//g it status  -red
	// git add .
	// git commit "message"
	//git push
	

}
