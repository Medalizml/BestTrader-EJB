package tn.esprit.Blues.ReclamationService;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Reclamation;


@Stateless
public class ReclServicesImpl implements ReclServices {

	@PersistenceContext(name="Blues")
	EntityManager manager;

	
	@Override
	public List<Reclamation> findAll() {
		Query query = manager.createQuery("SELECT c FROM Reclamation c");
		return query.getResultList();
	}

	@Override
	public void remove(Reclamation r) {
		manager.remove(findById(r.getId()));	
		}
	@Override
	public Reclamation findById(int id) {
	return manager.find(Reclamation.class,id);
		
	}
}