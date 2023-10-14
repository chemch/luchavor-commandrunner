package com.luchavor.commandrunner.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import com.luchavor.neo4japi.persistence.artifact.ArtifactRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.ConnectionRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.DnsEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.HttpEventRepo;
import com.luchavor.neo4japi.persistence.artifact.network.session.SessionRepo;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@ConditionalOnExpression("${command.deleteArtifacts.enabled:true}")
public class DeleteArtifactsCommand implements CommandLineRunner {
	
	@Autowired
	ArtifactRepo artifactRepo;
	
	@Autowired
	SessionRepo sessionRepo;
	
	@Autowired
	DnsEventRepo dnsEventRepo;
	
	@Autowired
	ConnectionRepo connectionRepo;
	
	@Autowired 
	HttpEventRepo httpEventRepo;
	
	@Override
	public void run(String... args) throws Exception {
		artifactRepo.deleteAll();
		sessionRepo.deleteAll();
		// delete all events and encompassing objects
		connectionRepo.deleteAll();
		dnsEventRepo.deleteAll();
		httpEventRepo.deleteAll();
		log.info("Delete Artifacts command complete.");
	}
}