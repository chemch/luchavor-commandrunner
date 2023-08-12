package com.luchavor.commandrunner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;

import com.luchavor.neo4japi.persistence.detection.DetectionRepo;
import com.luchavor.neo4japi.persistence.detection.ZeekNotificationRepo;
import com.luchavor.neo4japi.persistence.detection.state.ClosedDetectionStateRepo;
import com.luchavor.neo4japi.persistence.detection.state.OpenDetectionStateRepo;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@ConditionalOnExpression("${command.deleteDetections.enabled:true}")
public class DeleteDetectionsCommand implements CommandLineRunner {
	
	@Autowired
	OpenDetectionStateRepo openDetectionStateRepo;
	
	@Autowired
	ClosedDetectionStateRepo closedDetectionStateRepo;
	
	@Autowired
	DetectionRepo detectionRepo;
	
	@Autowired
	ZeekNotificationRepo zeekNotificationRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// delete detection state objects
		detectionRepo.deleteAll();
		closedDetectionStateRepo.deleteAll();
		openDetectionStateRepo.deleteAll();
		zeekNotificationRepo.deleteAll();
		log.info("Delete Detections command complete.");
	}
}