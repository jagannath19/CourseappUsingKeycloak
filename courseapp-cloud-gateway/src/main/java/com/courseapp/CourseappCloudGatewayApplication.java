package com.courseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author JagannathSutar
 *	Gateway main class
 *	Gateway use for run all the microservices in a single port
 */
@SpringBootApplication
@EnableEurekaClient
public class CourseappCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseappCloudGatewayApplication.class, args);
	}
	

	/**
	 * @param builder
	 * @return route path and uri
	 * Build the path of microservices using the name
	 */
	@Bean
	@LoadBalanced
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("courseService", ps->ps.path("/course-serv/**").uri("lb://COURSE-SERVICE"))
				.build();
	}

}
