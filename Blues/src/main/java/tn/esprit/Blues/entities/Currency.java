package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the currency database table.
 * 
 */
@Entity

public class Currency implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int unity;
	private List<Currencybank> currencybanks;

	public Currency() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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


	public int getUnity() {
		return this.unity;
	}

	public void setUnity(int unity) {
		this.unity = unity;
	}


	//bi-directional many-to-one association to Currencybank
	@OneToMany(mappedBy="currency")
	public List<Currencybank> getCurrencybanks() {
		return this.currencybanks;
	}

	public void setCurrencybanks(List<Currencybank> currencybanks) {
		this.currencybanks = currencybanks;
	}



}