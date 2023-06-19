
package com.luchavor.commandrunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import com.luchavor.commandrunner.data.CompositeTechniqueRepository;
import com.luchavor.commandrunner.data.SingleTechniqueRepository;

@SpringBootApplication
@EnableNeo4jRepositories
public class Command1Application {

	private final static Logger log = LoggerFactory.getLogger(Command1Application.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Command1Application.class, args);
		System.exit(0);
	}

	@Bean
	CommandLineRunner demo(CompositeTechniqueRepository compositeTechniqueRepository, SingleTechniqueRepository singleTechniqueRepository) {
		return args -> {
			// delete all techniques in neo4j database
			//compositeTechniqueRepository.deleteAll();
			//singleTechniqueRepository.deleteAll();
			
			// get some sample techniques 
			Technique composite = compositeTechniqueRepository.findByMitreId("T1548");
			Technique technique = singleTechniqueRepository.findByMitreId("T1548.002");
			
			// print out technique data
			System.out.println(composite);
			System.out.println(technique);
			
			// add single technique to composite
			composite.add(technique);
			CompositeTechnique trueComp = (CompositeTechnique) composite;
			
			// save composite
			compositeTechniqueRepository.save(trueComp);
		};
	}
}