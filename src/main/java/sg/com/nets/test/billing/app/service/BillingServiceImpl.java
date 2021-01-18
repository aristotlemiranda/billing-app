package sg.com.nets.test.billing.app.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sg.com.nets.test.billing.app.dao.DAOFactory;
import sg.com.nets.test.billing.app.entity.Billing;
import sg.com.nets.test.billing.app.exception.BillingException;

/**
 * @author Miranda Aristotle
 * */

@Service
public class BillingServiceImpl implements BillingService {
	

	@Autowired
	@Qualifier("daoFactory")
	DAOFactory factory;

	

	@Override
	public Billing getBill(UUID id) throws BillingException {
		return factory.getDAO().getBill(id);
	}



	@Override
	public Billing addBill(Billing bill) throws BillingException {
		return factory.getDAO().addBilling(bill);
	}



	@Override
	public Billing updateBill(Billing bill) throws BillingException {
		return factory.getDAO().updateBilling(bill);
	}

	
	
	
	
}
