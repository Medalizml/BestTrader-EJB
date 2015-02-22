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
	private float capital;
	private Float gain;

	private List<Operation> operations;
	private Customer customer;

	public Portfolio() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}
	public Float getGain() {
		return gain;
	}
	 
	public void setGain(Float gain) {
		this.gain = gain;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float getCapital() {
		return this.capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
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

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", capital=" + capital ;
	}
	
	
}