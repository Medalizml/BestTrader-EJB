package tn.esprit.Blues.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dateIncorporation;
	private String headOffice;
	private String logo;
	private String name;
	private String nature;
	private int nbShares;
	private int phone;
	private int quotedShares;
	private float socialCapital;
	private float socialShare;

	private Sector sector;
	private Quotation quotation;

	public Company() {
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
	public Date getDateIncorporation() {
		return this.dateIncorporation;
	}

	public void setDateIncorporation(Date dateIncorporation) {
		this.dateIncorporation = dateIncorporation;
	}

	public String getHeadOffice() {
		return this.headOffice;
	}

	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public int getNbShares() {
		return this.nbShares;
	}

	public void setNbShares(int nbShares) {
		this.nbShares = nbShares;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getQuotedShares() {
		return this.quotedShares;
	}

	public void setQuotedShares(int quotedShares) {
		this.quotedShares = quotedShares;
	}

	public float getSocialCapital() {
		return this.socialCapital;
	}

	public void setSocialCapital(float socialCapital) {
		this.socialCapital = socialCapital;
	}

	public float getSocialShare() {
		return this.socialShare;
	}

	public void setSocialShare(float socialShare) {
		this.socialShare = socialShare;
	}

	@ManyToOne
	public Sector getSector() {
		return this.sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	@OneToOne(mappedBy = "company",cascade=CascadeType.REMOVE)
	public Quotation getQuotation() {
		return this.quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}
	
	

}
