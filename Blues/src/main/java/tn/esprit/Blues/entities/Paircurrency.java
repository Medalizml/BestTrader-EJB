package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the paircurrency database table.
 * 
 */
@Entity
public class Paircurrency implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private float estimation;
	private float closingPrice;
	private List<Pairhistory> pairhistories;

	public Paircurrency() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "paircurrency")
	public List<Pairhistory> getPairhistories() {
		return this.pairhistories;
	}

	public void setPairhistories(List<Pairhistory> pairhistories) {
		this.pairhistories = pairhistories;
	}

	public float getEstimation() {
		return estimation;
	}

	public void setEstimation(float estimation) {
		this.estimation = estimation;
	}

	public float getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(float closingPrice) {
		this.closingPrice = closingPrice;
	}

}