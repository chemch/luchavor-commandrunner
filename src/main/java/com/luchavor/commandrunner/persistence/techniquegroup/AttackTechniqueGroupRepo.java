package com.luchavor.commandrunner.persistence.techniquegroup;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.luchavor.neo4japi.model.techniquegroup.AttackTechniqueGroup;

public interface AttackTechniqueGroupRepo extends CrudRepository<AttackTechniqueGroup, UUID> {
	/* only using default methods */
}