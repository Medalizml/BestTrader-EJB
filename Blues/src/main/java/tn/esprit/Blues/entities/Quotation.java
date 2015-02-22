
package tn.esprit.Blues.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the quotation database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Quotation implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private float closingPrice;
	private float highestPrice;
	private float lowestPrice;
	private float opningPrice;
	private float estimation;

	private List<Operation> operations;
	
	private List<Pricehistory> pricehistories;
	private Company company;

	public Quotation() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getClosingPrice() {
		return this.closingPrice;
	}

	public void setClosingPrice(float closingPrice) {
		this.closingPrice = closingPrice;
	}

	public float getHighestPrice() {
		return this.highestPrice;
	}

	public void setHighestPrice(float highestPrice) {
		this.highestPrice = highestPrice;
	}

	public float getLowestPrice() {
		return this.lowestPrice;
	}

	public void setLowestPrice(float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public float getOpningPrice() {
		return this.opningPrice;
	}

	public void setOpningPrice(float opningPrice) {
		this.opningPrice = opningPrice;
	}

	@OneToMany(mappedBy = "quotation",cascade=CascadeType.REMOVE)
	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@OneToMany(mappedBy = "quotation",cascade=CascadeType.REMOVE)
	public List<Pricehistory> getPricehistories() {
		return this.pricehistories;
	}

	public void setPricehistories(List<Pricehistory> pricehistories) {
		this.pricehistories = pricehistories;
	}

	@OneToOne
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public float getEstimation() {
		return estimation;
	}

	public void setEstimation(float estimation) {
		this.estimation = estimation;
	}

}