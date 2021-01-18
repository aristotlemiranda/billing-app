package sg.com.nets.test.billing.app.service;

import java.util.UUID;

import sg.com.nets.test.billing.app.entity.Billing;
import sg.com.nets.test.billing.app.exception.BillingException;


/**
 * @author Miranda Aristotle
 * */

public interface BillingService {
	
	public Billing addBill(Billing bill) throws BillingException;
	
	public Billing updateBill(Billing bill) throws BillingException;
	
	public Billing getBill(UUID id) throws BillingException;

	
}
