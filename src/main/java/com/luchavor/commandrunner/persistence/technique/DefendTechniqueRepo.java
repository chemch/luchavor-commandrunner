package com.luchavor.commandrunner.persistence.technique;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.model.technique.DefendTechnique;

public interface DefendTechniqueRepo extends CrudRepository<DefendTechnique, UUID> {
	Technique findByMitreId(@Param("mitreId") String mitreId);
	List<Technique> findByParentMitreId(@Param("mitreId") String mitreId);
}