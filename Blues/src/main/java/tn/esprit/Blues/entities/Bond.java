package tn.esprit.Blues.entities;

import java.io.Serializable;
import java.lang.Float;
import java.util.Date;

import javax.persistence.*;

import tn.esprit.Blues.entities.Quotation;

/**
 * Entity implementation class for Entity: Bond
 *
 */
@Entity
@DiscriminatorValue(value="bond")
public class Bond extends Quotation implements Serializable {

	
	private Float nominalValue;
	private Float emissionValue;
	private Float redemptionValue;
	private Date dateIssue;
	private Date closingDate;
	private Float nominalRate;
	private static final long serialVersionUID = 1L;

	public Bond() {
		super();
	}   
	public Float getNominalValue() {
		return this.nominalValue;
	}

	public void setNominalValue(Float nominalValue) {
		this.nominalValue = nominalValue;
	}   
	public Float getEmissionValue() {
		return this.emissionValue;
	}

	public void setEmissionValue(Float emissionValue) {
		this.emissionValue = emissionValue;
	}   
	public Float getRedemptionValue() {
		return this.redemptionValue;
	}

	public void setRedemptionValue(Float redemptionValue) {
		this.redemptionValue = redemptionValue;
	}   
	public Date getDateIssue() {
		return this.dateIssue;
	}

	public void setDateIssue(Date dateIssue) {
		this.dateIssue = dateIssue;
	}   
	public Date getClosingDate() {
		return this.closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}   
	public Float getNominalRate() {
		return this.nominalRate;
	}

	public void setNominalRate(Float nominalRate) {
		this.nominalRate = nominalRate;
	}
   
}
