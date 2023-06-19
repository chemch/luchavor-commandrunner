package com.luchavor.commandrunner.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.luchavor.commandrunner.SingleTechnique;
import com.luchavor.commandrunner.Technique;

public interface SingleTechniqueRepository extends Neo4jRepository<SingleTechnique, UUID> {
	Technique findByName(String name);
	Technique findByMitreId(String id);
}