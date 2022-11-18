package com.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author JagannathSutar
 *	This is the main class of this microservice
 *	Executon start form this
 */
@SpringBootApplication
@EnableEurekaClient
public class CourseappViewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappViewServiceApplication.class, args);
	}

}
