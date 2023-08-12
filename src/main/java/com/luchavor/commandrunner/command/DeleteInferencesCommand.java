package com.luchavor.commandrunner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;

import com.luchavor.neo4japi.persistence.inference.InferenceRepo;
import com.luchavor.neo4japi.persistence.inference.InferredHostRepo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@ConditionalOnExpression("${command.deleteInferences.enabled:true}")
public class DeleteInferencesCommand implements CommandLineRunner {
	
	@Autowired
	InferredHostRepo inferredHostRepo;
	
	@Autowired
	InferenceRepo inferenceRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// delete all
		inferenceRepo.deleteAll();
		inferredHostRepo.deleteAll();
		log.info("Delete Inferences command complete.");
	}
}