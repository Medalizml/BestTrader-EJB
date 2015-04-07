package tn.esprit.Blues.Services;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Customer;



import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;

@Remote
public interface CustomerServices {
	
	public void add(Customer c,Portfolio p);
	public void remove(Customer c);
	public Customer findById(int id);
	public void update(Customer c);
	public List<Customer> findAll();


	

}
