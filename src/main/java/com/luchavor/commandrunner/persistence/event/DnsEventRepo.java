package com.luchavor.commandrunner.persistence.event;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.luchavor.datamodel.artifact.network.session.dns.DnsEventImpl;

public interface DnsEventRepo extends CrudRepository<DnsEventImpl, UUID> {
	/* only using default methods */
}