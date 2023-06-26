package com.luchavor.commandrunner.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.luchavor.datamodel.technique.Technique;
import com.luchavor.neo4japi.model.DefendTechniqueGroup;

public interface DefendTechniqueGroupRepo extends CrudRepository<DefendTechniqueGroup, UUID> {
	Technique findByMitreId(@Param("mitreId") String mitreId);
	List<Technique> findByParentMitreId(@Param("mitreId") String mitreId);
}