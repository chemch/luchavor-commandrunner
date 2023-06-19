package com.luchavor.commandrunner;

import java.util.List;
import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SingleTechniqueRepository extends Neo4jRepository<SingleTechnique, UUID> {
	Technique findByName(String name);
	Technique findByMitreId(String id);
}