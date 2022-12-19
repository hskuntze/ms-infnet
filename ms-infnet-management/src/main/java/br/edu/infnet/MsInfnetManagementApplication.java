package br.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Management - MS-INFNET", version = "1.0", contact = @Contact(email = "kuntzedevprojects@gmail.com", name = "Hassan Kuntze")),
				   servers = {@Server(url = "http://localhost:8081")})
public class MsInfnetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInfnetManagementApplication.class, args);
	}
}
