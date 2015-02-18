package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Indexmarket;

@Stateless
public class IndexmarketServicesImpl implements IndexmarketServices{
	@PersistenceContext(name="Blues")
	EntityManager manager;
	@Override
	public void add(Indexmarket i) {
		manager.persist(i);
		
	}

	@Override
	public void remove(Indexmarket i) {
		manager.remove(findById(i.getId()));
		
	}

	@Override
	public Indexmarket findById(int id) {
		return manager.find(Indexmarket.class, id);
	}

	@Override
	public void update(Indexmarket i) {
		manager.merge(i);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Indexmarket> findAll() {
		Query query = manager.createQuery("SELECT i FROM Indexmarket i ");
		return query.getResultList();
	}

}
