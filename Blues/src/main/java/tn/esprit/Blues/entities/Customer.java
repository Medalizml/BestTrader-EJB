package tn.esprit.Blues.entities;

import java.awt.List;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;






import javax.persistence.*;

import tn.esprit.Blues.entities.User;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@DiscriminatorValue(value="customer")
public class Customer extends User implements Serializable {

	
	

	private String job;
	private String nationality;
	private Integer phoneNumber;
	private String address;
	
	 
	
	 
	
	 
	 
	 private static final long serialVersionUID = 1L;
	 


	private Portfolio portfolio;
	

		@OneToOne(mappedBy="customer",cascade=CascadeType.REMOVE)
		public Portfolio getPortfolio() {
			return this.portfolio;
		}

		public void setPortfolio(Portfolio portfolio) {
			this.portfolio = portfolio;
		}

	public Customer() {
		super();
	}   
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}   
	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}   
	public Integer getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}   
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}   
	

	@Override
	public String toString() {
		return "Customer [getId()=" + getId() + ", getEmail()=" + getEmail()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() ;
	}
   
}
