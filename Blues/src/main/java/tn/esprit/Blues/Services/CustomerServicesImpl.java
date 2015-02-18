package tn.esprit.Blues.Services;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.registry.infomodel.User;

import tn.esprit.Blues.entities.Customer;

@Stateless

public class CustomerServicesImpl implements CustomerServices{
	
	@PersistenceContext(name="Blues")
	EntityManager manager;
	@Override
	public void add(Customer c) {
		manager.persist(c);
		
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
	Query query = manager.createQuery("SELECT u FROM Customer u");
	return query.getResultList();
}
	

}
