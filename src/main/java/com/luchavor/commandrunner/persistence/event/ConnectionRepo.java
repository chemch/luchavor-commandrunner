package com.luchavor.commandrunner.persistence.event;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.luchavor.datamodel.artifact.network.session.connection.ConnectionImpl;

public interface ConnectionRepo extends CrudRepository<ConnectionImpl, UUID> {
	/* only using default methods */
}