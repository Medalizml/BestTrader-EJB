package tn.esprit.Blues.Services;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Customer;



import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Customer;

@Remote
public interface CustomerServices {
	
	public void add(Customer c);
	public void remove(Customer c);
	public Customer findById(int id);
	public void update(Customer c);
	public List<Customer> findAll();


}
