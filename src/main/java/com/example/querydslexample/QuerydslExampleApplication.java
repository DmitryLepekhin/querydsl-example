package com.example.querydslexample;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class QuerydslExampleApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(QuerydslExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (String name : Arrays.asList("David", "Charles")) {
			User user = new User();
			user.setName(name);
			userRepository.save(user);
		}
		userRepository.flush();


		QUser user = QUser.user;
		BooleanExpression predicate = user.name.contains("vid");
		for (User result: userRepository.findAll(predicate)) {
			System.out.println(result.getName());
		}
	}
}
