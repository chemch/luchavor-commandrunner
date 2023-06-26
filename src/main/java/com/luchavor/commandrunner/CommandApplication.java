
package com.luchavor.commandrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import com.luchavor.commandrunner.data.AttackTechniqueRepo;
import com.luchavor.commandrunner.data.DefendTechniqueRepo;
import com.luchavor.commandrunner.data.TechniqueGroupRepo;

@SpringBootApplication
@EnableNeo4jRepositories
public class CommandApplication {

	@SuppressWarnings("unused")
	private final static Logger log = LoggerFactory.getLogger(CommandApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CommandApplication.class, args);
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner deleteTechniques(TechniqueGroupRepo techniqueGroupRepo, AttackTechniqueRepo attackTechniqueRepo, DefendTechniqueRepo defendTechniqueRepo) {
		return args -> {
			// delete all techniques in neo4j database
			techniqueGroupRepo.deleteAll();
			attackTechniqueRepo.deleteAll();
			defendTechniqueRepo.deleteAll();
		};
	}
}