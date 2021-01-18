package sg.com.nets.test.billing.app.exception;

import org.springframework.dao.DataIntegrityViolationException;

/**
 * @author Miranda Aristotle
 * */

public class BillingException extends DataIntegrityViolationException {


	private static final long serialVersionUID = -85600237744736455L;
	
	public BillingException(String message) {
		super(message);
	}
}
