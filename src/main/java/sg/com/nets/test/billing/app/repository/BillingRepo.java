package sg.com.nets.test.billing.app.repository;


import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import sg.com.nets.test.billing.app.entity.Billing;

/**
 * @author Miranda Aristotle
 * */

public interface BillingRepo extends JpaRepository<Billing, UUID>{

}
