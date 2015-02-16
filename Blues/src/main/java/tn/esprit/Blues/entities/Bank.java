package tn.esprit.Blues.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tn.esprit.Blues.entities.Company;

/**
 * Entity implementation class for Entity: Bank
 *
 */
@Entity
@DiscriminatorValue(value="bank")
public class Bank extends Company implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private List<Currencybank> currencybanks;
	
	
@OneToMany(mappedBy="bank")
	public List<Currencybank> getCurrencybanks() {
		return currencybanks;
	}



	public void setCurrencybanks(List<Currencybank> currencybanks) {
		this.currencybanks = currencybanks;
	}



	public Bank() {
		super();
	}
   
}
