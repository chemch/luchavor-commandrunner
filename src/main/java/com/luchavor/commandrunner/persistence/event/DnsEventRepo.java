package com.luchavor.commandrunner.persistence.event;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.luchavor.datamodel.event.EventType;
import com.luchavor.datamodel.event.dns.Dns;
import com.luchavor.neo4japi.model.event.Neo4jDnsEvent;

public interface DnsEventRepo extends CrudRepository<Neo4jDnsEvent, UUID> {
	Dns findByEventType(@Param("eventType") EventType eventType);
}