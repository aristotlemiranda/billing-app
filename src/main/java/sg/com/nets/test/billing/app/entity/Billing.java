package sg.com.nets.test.billing.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import sg.com.nets.test.billing.app.model.StringConstant;

/**
 * @author Miranda Aristotle
 * */

@Entity
@Table(name= StringConstant.TBL_BILLING)
public class Billing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@org.springframework.data.neo4j.core.schema.Id
	private UUID id;
	
	private int patientId;
	
	private int physicianId;
	
	private int visitId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date billedDateTime;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	public Date getBilledDateTime() {
		return billedDateTime;
	}

	public void setBilledDateTime(Date billedDateTime) {
		this.billedDateTime = billedDateTime;
	}
	
	

}
