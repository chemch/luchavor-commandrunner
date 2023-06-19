package com.luchavor.commandrunner;

import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CompositeTechniqueRepository extends Neo4jRepository<CompositeTechnique, UUID> {
	Technique findByName(String name);
	Technique findByMitreId(String id);
}