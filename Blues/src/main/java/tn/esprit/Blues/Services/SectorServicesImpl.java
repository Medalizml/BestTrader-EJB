package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Sector;

@Stateless
public class SectorServicesImpl implements SectorServices {
	@PersistenceContext(name="Blues")
	EntityManager manager;
	@Override
	public void add(Sector s) {
		manager.persist(s);
		
	}

	@Override
	public void remove(Sector s) {
		manager.remove(findById(s.getId()));
		
	}

	@Override
	public Sector findById(int id) {
		return manager.find(Sector.class,id);
	}

	@Override
	public void update(Sector s) {
		manager.merge(s);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sector> findAll() {
		Query query = manager.createQuery("SELECT s FROM Sector s ");
		return query.getResultList();
	}

}
