package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indexmarket database table.
 * 
 */
@Entity
public class Indexmarket implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private float closingPrice;
	private String code;
	private float heighestPrice;
	private String label;
	private float lowestPrice;
	private float opningPrice;

	private Sector sector;

	public Indexmarket() {
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

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getHeighestPrice() {
		return this.heighestPrice;
	}

	public void setHeighestPrice(float heighestPrice) {
		this.heighestPrice = heighestPrice;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	@OneToOne(mappedBy = "indexmarket")
	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

}