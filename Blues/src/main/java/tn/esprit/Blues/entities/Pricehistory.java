package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the pricehistory database table.
 * 
 */
@Entity
public class Pricehistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private float closingPrice;
	private float highestPrice;
	private float lowestPrice;
	private float opningPrice;
	private Date time;

	private Quotation quotation;

	public Pricehistory() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@ManyToOne
	public Quotation getQuotation() {
		return this.quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	@Override
	public String toString() {
		return "Pricehistory [id=" + id + ", price="  + "]";
	}

	public float getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(float closingPrice) {
		this.closingPrice = closingPrice;
	}

	public float getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(float highestPrice) {
		this.highestPrice = highestPrice;
	}

	public float getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public float getOpningPrice() {
		return opningPrice;
	}

	public void setOpningPrice(float opningPrice) {
		this.opningPrice = opningPrice;
	}
	
}