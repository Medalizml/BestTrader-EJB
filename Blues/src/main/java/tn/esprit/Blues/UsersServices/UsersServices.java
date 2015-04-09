package tn.esprit.Blues.UsersServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;

@Local
public interface UsersServices {
	
	public List<Customer> findAll();
	public void remove(Customer c);
	public Customer findById(int id);
	public void update(Portfolio p);

}
