package tn.esprit.Blues.StatServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Customer;

@Stateless
public class StatServicesImpl implements StatServices {
	@PersistenceContext(name = "Blues")
	EntityManager manager;

	@Override
	public String getName() {
		Query query = manager
				.createQuery("SELECT c.name FROM Company c where c.id='" + 1
						+ "'");
		return (String) query.getSingleResult();
	}

	@Override
	public List<Customer> getList() {
		
		Query query = manager.createQuery("SELECT u FROM Customer u ");
		return query.getResultList();
	}

	@Override
	public List<Customer> getOrderedList() {
		Query query = manager.createQuery("SELECT u FROM Customer u ORDER BY u.portfolio.gain DESC ");
		return query.getResultList();
	}

}
