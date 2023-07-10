package com.luchavor.commandrunner.persistence.technique;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.luchavor.neo4japi.model.technique.AttackTechnique;

public interface AttackTechniqueRepo extends CrudRepository<AttackTechnique, UUID> {
	/* only using default methods */
}