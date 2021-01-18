package sg.com.nets.test.billing.app.controller;

import java.util.UUID;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import sg.com.nets.test.billing.app.entity.Billing;
import sg.com.nets.test.billing.app.exception.BillingException;
import sg.com.nets.test.billing.app.model.StringConstant;
import sg.com.nets.test.billing.app.service.BillingService;

/**
 * @author Miranda Aristotle
 * 
 ***/

@RequestMapping("/api/billing")
@RestController
@Validated
@Api(value = "Billing Controller")
public class BillingController {

	@Autowired
	private BillingService service;

	@ApiOperation(value = "Get Billing Information", response = Billing.class, notes = "Returns a single object Billing.class.")
	@GetMapping("/{id}")
	public ResponseEntity<Billing> getBilling(
			@ApiParam(value = "This is the Billing's entity id") @PathVariable("id") UUID id) throws BillingException {

		Billing bill = service.getBill(id);

		if (bill != null) {
			return ResponseEntity.status(HttpStatus.OK).body(bill);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}

	}

	@ApiOperation(value = "Add record into the Billing table", response = Billing.class, notes = "Returns a ResponseEntity<?>.")
	@PostMapping
	public ResponseEntity<?> addBilling(
			@ApiParam(value = "Pass Billing details by providing a JSON formatted request body") @RequestBody Billing bill)
			throws JSONException, BillingException {
		ResponseEntity<Billing> obj = null;
		if (bill != null && bill.getId() != null) {
			obj = this.getBilling(bill.getId());
		}

		Billing entity = null;

		if ((bill.getId() == null || obj.getStatusCode().equals(HttpStatus.NO_CONTENT))) {
			entity = service.addBill(bill);
		} else {
			return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(StringConstant.MSG_BILLING_EXIST);
		}

		return ResponseEntity.status(HttpStatus.OK).body(entity);
	}

	@ApiOperation(value = "Updates the record into the Billing table", response = Billing.class, notes = "Returns a ReponseEntity<String>")
	@PutMapping
	public ResponseEntity<String> updateBilling(
			@ApiParam(value = "Pass Billing details by providing a JSON formatted request body") @RequestBody Billing bill) throws BillingException {
		ResponseEntity<String> responseEntity = null;

		ResponseEntity<Billing> obj = this.getBilling(bill.getId());
		if (obj.getStatusCode().equals(HttpStatus.OK)) {
			responseEntity = ResponseEntity.status(HttpStatus.FOUND).body(StringConstant.MSG_BILLING_UPDATED);
		} else {
			responseEntity = ResponseEntity.status(HttpStatus.OK).body(StringConstant.MSG_BILLING_ADDED);
		}
		service.updateBill(bill);
		return responseEntity;
	}
}
