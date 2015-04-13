package tn.esprit.Blues.entities;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;






import java.util.List;

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
	
	private List<Reclamation> reclamations;

	private Integer age;
	private boolean active;
	

	 
	
	 
	
	 
	 
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
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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

@OneToMany(mappedBy="sender",cascade=CascadeType.REMOVE)
	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}


	@Override
	public String toString() {
		return "Customer [getId()=" + getId() + ", getEmail()=" + getEmail()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() ;
	}
   
}
