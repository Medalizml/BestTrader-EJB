package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Bank;
/**
 * 
 * @author Maleck
 *
 */
@Stateless
public class BankServicesImpl implements BankServices {
	@PersistenceContext(name = "Blues")
	EntityManager manager;

	@Override
	public void add(Bank b) {
		manager.persist(b);

	}

	@Override
	public void remove(Bank b) {
		manager.remove(findById(b.getId()));

	}

	@Override
	public Bank findById(int id) {
		return manager.find(Bank.class, id);
	}

	@Override
	public void update(Bank b) {
		manager.merge(b);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> findAll() {
		Query query = manager.createQuery("SELECT u FROM company u");
		return query.getResultList();
	}

}
