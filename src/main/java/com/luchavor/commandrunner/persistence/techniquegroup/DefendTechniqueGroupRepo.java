package com.luchavor.commandrunner.persistence.techniquegroup;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.luchavor.neo4japi.model.techniquegroup.DefendTechniqueGroup;

public interface DefendTechniqueGroupRepo extends CrudRepository<DefendTechniqueGroup, UUID> {
	/* only using default methods */
}