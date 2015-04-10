package tn.esprit.Blues.UsersServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;

@Stateless
public class UsersServicesImpl implements UsersServices{
	
	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		
	Query query = manager.createQuery("SELECT u FROM Customer u WHERE u.active IS TRUE ");

		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAllNoActif() {
		
	Query query = manager.createQuery("SELECT u FROM Customer u WHERE u.active IS FALSE ");

		return query.getResultList();
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
	public void update(Portfolio p) {
		manager.merge(p);
		
	}
	
	@Override
	public void update(Customer c) {
		manager.merge(c);	
		
	}

}
