package sg.com.nets.test.billing.app.repository;


import java.util.UUID;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import sg.com.nets.test.billing.app.entity.Billing;


/**
 * @author Miranda Aristotle
 * */

public interface BillingNeo4jRepo extends Neo4jRepository<Billing, UUID>{
	
	
}
