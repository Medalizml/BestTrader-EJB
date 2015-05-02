package tn.esprit.Blues.UsersServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Article;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;

@Local
public interface UsersServices {
	
	public void add(Customer c);
	public List<Customer> findAll();
	public List<Customer> findAllNoActif();
	public void remove(Customer c);
	public Customer findById(int id);
	public void update(Portfolio p);
	public void update(Customer c);

}
