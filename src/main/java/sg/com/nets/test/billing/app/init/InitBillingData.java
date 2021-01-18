package sg.com.nets.test.billing.app.init;

import java.text.ParseException;
import java.util.Calendar;
import java.util.UUID;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import sg.com.nets.test.billing.app.entity.Billing;
import sg.com.nets.test.billing.app.model.StringConstant;
import sg.com.nets.test.billing.app.repository.BillingNeo4jRepo;
import sg.com.nets.test.billing.app.repository.BillingRepo;

/**
 * @author Miranda Aristotle
 * */

@Component
public class InitBillingData {


	@Autowired
	private BillingRepo repo;
	
	@Autowired
	private BillingNeo4jRepo neo4jRepo;
	
	@Value("${config.database-type}")
   	private String databaseType;
	
	@PostConstruct
	void createBillingData() throws ParseException {
		Billing bill = new Billing();
		bill.setId(UUID.randomUUID());
		bill.setPatientId(1);
		bill.setPhysicianId(1);
		bill.setVisitId(1);
		bill.setBilledDateTime(Calendar.getInstance().getTime());
		
		if (StringConstant.DB_NEO4J.equals(databaseType)) {
			
			try {
				neo4jRepo.findById(bill.getId()).get();
			} catch (Exception e) {
				neo4jRepo.save(bill);
			}
		} 
		if (StringConstant.DB_MYSQL.equals(databaseType)) {
			try {
				repo.findById(bill.getId()).get();
			} catch (Exception e) {
				repo.save(bill);
			}
		}
	}
}
