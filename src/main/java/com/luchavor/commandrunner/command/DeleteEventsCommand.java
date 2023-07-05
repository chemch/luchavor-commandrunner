package com.luchavor.commandrunner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import com.luchavor.commandrunner.persistence.event.ConnectionRepo;
import com.luchavor.commandrunner.persistence.event.DnsEventRepo;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@ConditionalOnExpression("${command.deleteEvents.enabled:true}")
public class DeleteEventsCommand implements CommandLineRunner {
	
	@Autowired
	ConnectionRepo connectionRepo;
	
	@Autowired
	DnsEventRepo dnsEventRepo;

	@Override
	public void run(String... args) throws Exception {
				// delete all events in neo4j database
				connectionRepo.deleteAll();
				dnsEventRepo.deleteAll();
				log.info("Delete Connections command complete.");
	}
}