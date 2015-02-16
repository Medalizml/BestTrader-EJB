package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the currencybank database table.
 * 
 */
@Entity

public class Currencybank implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private float buyPrice;
	private float sellPrice;
	private Currency currency;

	private Bank bank;
	
	
@ManyToOne
	public Bank getBank() {
		return bank;
	}


	public void setBank(Bank bank) {
		this.bank = bank;
	}


	public Currencybank() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public float getBuyPrice() {
		return this.buyPrice;
	}

	public void setBuyPrice(float buyPrice) {
		this.buyPrice = buyPrice;
	}


	public float getSellPrice() {
		return this.sellPrice;
	}

	public void setSellPrice(float sellPrice) {
		this.sellPrice = sellPrice;
	}


	//bi-directional many-to-one association to Currency
	@ManyToOne
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	

}