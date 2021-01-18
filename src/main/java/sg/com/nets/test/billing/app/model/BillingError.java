package sg.com.nets.test.billing.app.model;

import org.springframework.http.HttpStatus;


/**
 * @author Miranda Aristotle
 * */

public class BillingError {
	
	private String errorMessage;
	private HttpStatus status;
	
	public BillingError(String errorMessage, HttpStatus status) {
		this.errorMessage = errorMessage;
		this.status = status;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
