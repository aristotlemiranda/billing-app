package sg.com.nets.test.billing.app.dao;

import java.util.UUID;

import sg.com.nets.test.billing.app.entity.Billing;

/**
 * @author Miranda Aristotle
 * **/

public interface BillingDAO  {

	public Billing addBilling(Billing bill);
	
	public Billing updateBilling(Billing bill);

	public Billing getBill(UUID id);

}
