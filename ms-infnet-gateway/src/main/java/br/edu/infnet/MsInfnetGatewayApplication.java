package br.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class MsInfnetGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInfnetGatewayApplication.class, args);
	}
	
	@Bean
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/users/**").uri("http://localhost:8080"))
				.route(r -> r.path("/departments/**").uri("http://localhost:8082"))
				.build();
	}
	
	@GetMapping
	public Mono<String> fallback(){
		return Mono.just("fallback");
	}
}
