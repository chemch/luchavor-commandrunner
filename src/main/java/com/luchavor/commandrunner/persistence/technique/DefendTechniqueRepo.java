package com.luchavor.commandrunner.persistence.technique;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

import com.luchavor.datamodel.technique.DefendTechnique;

public interface DefendTechniqueRepo extends CrudRepository<DefendTechnique, UUID> {
	/* only using default methods */
}