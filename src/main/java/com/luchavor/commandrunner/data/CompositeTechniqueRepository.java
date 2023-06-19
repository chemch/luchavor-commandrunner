package com.luchavor.commandrunner.data;

import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.luchavor.commandrunner.CompositeTechnique;
import com.luchavor.commandrunner.Technique;

public interface CompositeTechniqueRepository extends Neo4jRepository<CompositeTechnique, UUID> {
	Technique findByName(String name);
	Technique findByMitreId(String id);
}