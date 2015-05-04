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
	public List<Reclamation> findAll(Customer customer) {
		Query query = manager.createQuery("SELECT c FROM Reclamation c where c.sender=:customer");
		query.setParameter("customer", customer);
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

	@Override
	public long numberRec() {
		Query query = manager.createQuery("SELECT COUNT(c) FROM Reclamation c");
		
		long count =  (long) query.getSingleResult() ;
		return count;
	}

	@Override
	public void addReclamation(Reclamation r) {

		manager.persist(r);
	}

	@Override
	public List<Reclamation> findAll() {
		Query query = manager.createQuery("SELECT c FROM Reclamation c");
		
		return query.getResultList();
	}
}
