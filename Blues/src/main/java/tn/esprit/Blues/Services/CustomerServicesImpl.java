package tn.esprit.Blues.Services;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;





import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;

@Stateless

public class CustomerServicesImpl implements CustomerServices{
	@PersistenceContext(name="Blues")
	EntityManager manager;
	@Override
	public void add(Customer c, Portfolio p) {
		manager.persist(c);
		manager.persist(p);
		
		
		
	}
	
	@Override
	public void remove(Customer c) {
		manager.remove(findById(c.getId()));	
		}
	@Override
	public Customer findById(int id) {
	return manager.find(Customer.class,id);
		
	}
	
@Override
	public void update(Customer c) {
		manager.merge(c);	
		
	}

@SuppressWarnings("unchecked")
@Override
public List<Customer> findAll() {
	Query query = manager.createQuery("SELECT u FROM Customer u  ");
	return query.getResultList();
}




}
