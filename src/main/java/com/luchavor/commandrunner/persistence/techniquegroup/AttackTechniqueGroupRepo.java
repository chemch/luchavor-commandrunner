package com.luchavor.commandrunner.persistence.techniquegroup;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

import com.luchavor.datamodel.techniquegroup.AttackTechniqueGroup;

public interface AttackTechniqueGroupRepo extends CrudRepository<AttackTechniqueGroup, UUID> {
	/* only using default methods */
}