package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Student s = new Student();
		s.setFirstName("pradeep");
		s.setLastName("kumar");
		s.setId(491L);
		
		System.out.println(s);
		System.out.println("======================");
		System.out.println(s.getId()+"-"+s.getFirstName()+"-"+s.getLastName());
	}

}
