package com.luchavor.commandrunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
@ComponentScan({"com.luchavor.commandrunner","com.luchavor.neo4japi"})
public class CommandApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CommandApplication.class, args);
		System.exit(0);
	}
}