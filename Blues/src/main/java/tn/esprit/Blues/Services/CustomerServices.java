package tn.esprit.Blues.Services;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Customer;

@Remote
public interface CustomerServices {
	
	public void add(Customer c);
	

}
