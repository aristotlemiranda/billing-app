package sg.com.nets.test.billing.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sg.com.nets.test.billing.app.exception.BillingException;
import sg.com.nets.test.billing.app.model.BillingError;
import sg.com.nets.test.billing.app.model.ErrorType;

/**
 * @author Miranda Aristotle
 * 
 ***/

@ControllerAdvice
public class ExceptionAdviceController {
	
	@ExceptionHandler(BillingException.class)
	public ResponseEntity<BillingError> handleException(BillingException ex) {
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		if(ErrorType.DUPLICATE_ID.getCode().equals(ex.getMessage())) {
			status = HttpStatus.ALREADY_REPORTED;
		}
		
		if(ErrorType.ACTION_NOT_ALLOWED_DURING_HOLIDAY.getCode().equals(ex.getMessage())
				|| ErrorType.NO_RECORD_FOUND.getCode().equals(ex.getMessage())) {
			
			status = HttpStatus.BAD_REQUEST;
		}
		  
		BillingError error = new BillingError(ex.getMessage(), status);
		return new ResponseEntity<BillingError>(error ,status);	
	}
}
