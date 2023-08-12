package com.luchavor.commandrunner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;

import com.luchavor.neo4japi.persistence.detection.ZeekNotificationRepo;
import com.luchavor.neo4japi.persistence.finding.FindingRepo;
import com.luchavor.neo4japi.persistence.finding.state.ConfirmedFindingStateRepo;
import com.luchavor.neo4japi.persistence.finding.state.PotentialFindingStateRepo;
import com.luchavor.neo4japi.persistence.finding.state.RefutedFindingStateRepo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@ConditionalOnExpression("${command.deleteFindings.enabled:true}")
public class DeleteFindingsCommand implements CommandLineRunner {
	
	@Autowired
	RefutedFindingStateRepo refutedFindingStateRepo;
	
	@Autowired
	PotentialFindingStateRepo potentialFindingStateRepo;
	
	@Autowired
	ConfirmedFindingStateRepo confirmedFindingStateRepo;
	
	@Autowired
	FindingRepo findingRepo;
	
	@Autowired
	ZeekNotificationRepo zeekNotificationRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// delete all objects
		findingRepo.deleteAll();
		confirmedFindingStateRepo.deleteAll();
		potentialFindingStateRepo.deleteAll();
		refutedFindingStateRepo.deleteAll();
		log.info("Delete Findings command complete.");
	}
}