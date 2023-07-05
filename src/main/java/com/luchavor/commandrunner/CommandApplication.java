package com.luchavor.commandrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class CommandApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CommandApplication.class, args);
		System.exit(0);
	}
}