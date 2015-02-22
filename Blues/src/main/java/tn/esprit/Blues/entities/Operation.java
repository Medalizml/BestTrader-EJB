package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the operation database table.
 * 
 */
@Entity
@NamedQuery(name = "Operation.findAll", query = "SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dateOperation;
	private int numberShares;
	private float sharePrice;

	private Quotation quotation;
	private Portfolio portfolio;

	public Operation() {
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
	public Date getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public int getNumberShares() {
		return this.numberShares;
	}

	public void setNumberShares(int numberShares) {
		this.numberShares = numberShares;
	}

	public float getSharePrice() {
		return this.sharePrice;
	}

	public void setSharePrice(float sharePrice) {
		this.sharePrice = sharePrice;
	}

	@ManyToOne
	public Quotation getQuotation() {
		return this.quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	@ManyToOne
	public Portfolio getPortfolio() {
		return this.portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", numberShares=" + numberShares + "]";
	}
	
	
	
}