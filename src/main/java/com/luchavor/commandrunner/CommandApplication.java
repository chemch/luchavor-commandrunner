package com.luchavor.commandrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import com.luchavor.commandrunner.persistence.event.ConnectionRepo;
import com.luchavor.commandrunner.persistence.event.DnsEventRepo;
import com.luchavor.commandrunner.persistence.technique.AttackTechniqueRepo;
import com.luchavor.commandrunner.persistence.technique.DefendTechniqueRepo;
import com.luchavor.commandrunner.persistence.techniquegroup.AttackTechniqueGroupRepo;
import com.luchavor.commandrunner.persistence.techniquegroup.DefendTechniqueGroupRepo;

@SpringBootApplication
@EnableNeo4jRepositories
public class CommandApplication {
	private final static Logger log = LoggerFactory.getLogger(CommandApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CommandApplication.class, args);
		System.exit(0);
	}
	
	@Bean
	CommandLineRunner deleteTechniques(AttackTechniqueGroupRepo attackTechniqueGroupRepo, DefendTechniqueGroupRepo defendTechniqueGroupRepo, 
			AttackTechniqueRepo attackTechniqueRepo, DefendTechniqueRepo defendTechniqueRepo) {
		return args -> {
			// delete all techniques in neo4j database
			attackTechniqueGroupRepo.deleteAll();
			defendTechniqueGroupRepo.deleteAll();
			attackTechniqueRepo.deleteAll();
			defendTechniqueRepo.deleteAll();
			log.info("Delete Techniques command complete.");
		};
	}
	
	@Bean
	CommandLineRunner deleteEvents(ConnectionRepo connectionRepo, DnsEventRepo dnsEventRepo) {
		return args -> {
			// delete all events in neo4j database
			connectionRepo.deleteAll();
			dnsEventRepo.deleteAll();
			log.info("Delete Connections command complete.");
		};
	}
}