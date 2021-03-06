package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the pairhistory database table.
 * 
 */
@Entity
public class Pairhistory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int price;
	private Date time;
	private Paircurrency paircurrency;

	public Pairhistory() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@ManyToOne
	public Paircurrency getPaircurrency() {
		return this.paircurrency;
	}

	public void setPaircurrency(Paircurrency paircurrency) {
		this.paircurrency = paircurrency;
	}

}