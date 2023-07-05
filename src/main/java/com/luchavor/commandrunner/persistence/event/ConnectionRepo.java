package com.luchavor.commandrunner.persistence.event;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.luchavor.datamodel.event.EventType;
import com.luchavor.datamodel.event.connection.Connection;
import com.luchavor.neo4japi.model.event.Neo4jConnection;

public interface ConnectionRepo extends CrudRepository<Neo4jConnection, UUID> {
	Connection findByEventType(@Param("eventType") EventType eventType);
}