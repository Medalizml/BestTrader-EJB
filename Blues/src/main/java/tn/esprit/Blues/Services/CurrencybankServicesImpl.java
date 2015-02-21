package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Currencybank;
@Stateless
public class CurrencybankServicesImpl implements CurrencybankServices{
	@PersistenceContext(name="Blues")
	EntityManager manager;
	@Override
	public void add(Currencybank c) {
		manager.persist(c);
		
	}

	@Override
	public void remove(Currencybank c) {
		manager.remove(findById(c.getId()));
		
	}

	@Override
	public Currencybank findById(int id) {
		return manager.find(Currencybank.class,id);
	}

	@Override
	public void update(Currencybank c) {
		manager.merge(c);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Currencybank> findAll() {
		Query query = manager.createQuery("SELECT c FROM Currencybank c ");
		return query.getResultList();
	}

}
