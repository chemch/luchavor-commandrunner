package com.luchavor.commandrunner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import com.luchavor.commandrunner.persistence.technique.AttackTechniqueRepo;
import com.luchavor.commandrunner.persistence.technique.DefendTechniqueRepo;
import com.luchavor.commandrunner.persistence.techniquegroup.AttackTechniqueGroupRepo;
import com.luchavor.commandrunner.persistence.techniquegroup.DefendTechniqueGroupRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ConditionalOnExpression("${command.deleteTechniques.enabled:true}")
public class DeleteTechniquesCommand implements CommandLineRunner {
	
	@Autowired
	AttackTechniqueGroupRepo attackTechniqueGroupRepo;
	
	@Autowired
	DefendTechniqueGroupRepo defendTechniqueGroupRepo;
	
	@Autowired
	AttackTechniqueRepo attackTechniqueRepo;
	
	@Autowired
	DefendTechniqueRepo defendTechniqueRepo;

	@Override
	public void run(String... args) throws Exception {
			// delete all techniques in neo4j database
			attackTechniqueGroupRepo.deleteAll();
			defendTechniqueGroupRepo.deleteAll();
			attackTechniqueRepo.deleteAll();
			defendTechniqueRepo.deleteAll();
			log.info("Delete Techniques command complete.");
	}
}