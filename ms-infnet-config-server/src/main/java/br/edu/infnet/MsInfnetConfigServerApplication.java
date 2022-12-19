package br.edu.infnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsInfnetConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsInfnetConfigServerApplication.class, args);
	}
}
