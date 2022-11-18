package com.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author JagannathSutar
 * Main class of cloud config
 * Cloud config use to store all the properties source in cloud
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CourseappCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappCloudConfigApplication.class, args);
	}

}
