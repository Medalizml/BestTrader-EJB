package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the portfolio database table.
 * 
 */
@Entity
public class Portfolio implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private float value;
	private int sharesNumber;

	private List<Operation> operations;
	private Customer customer;

	public Portfolio() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getSharesNumber() {
		return sharesNumber;
	}

	public void setSharesNumber(int sharesNumber) {
		this.sharesNumber = sharesNumber;
	}

	@OneToMany(mappedBy = "portfolio")
	public List<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	@OneToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}