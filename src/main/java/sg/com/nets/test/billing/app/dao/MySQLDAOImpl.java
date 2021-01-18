package sg.com.nets.test.billing.app.dao;


import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sg.com.nets.test.billing.app.entity.Billing;
import sg.com.nets.test.billing.app.repository.BillingRepo;


/**
 * @author Miranda Aristotle
 * */

@Repository("mysqlJPA")
@Transactional(transactionManager = "chainedTractionMgr")
public class MySQLDAOImpl implements BillingDAO {

	@Autowired
	BillingRepo repo;
	

	@Override
	public Billing getBill(UUID id) {
		
		Optional<Billing> bill = repo.findById(id);
		
		try {
			return bill.get();
		} catch (Exception e) {
			return null;
		}	
	}


	@Override
	public Billing addBilling(Billing bill) {
		
		if(bill.getId() == null) {
			bill.setId(UUID.randomUUID());
		}
		
		return repo.saveAndFlush(bill);
	}


	@Override
	public Billing updateBilling(Billing bill) {
		return repo.save(bill);
	}
	
	
}
