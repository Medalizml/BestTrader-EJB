package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Paircurrency;
import tn.esprit.Blues.entities.Share;

@Stateless
public class PaircurrencyServicesImpl implements PaircurrencyServices {
	@PersistenceContext(name="Blues")
	EntityManager manager;
	@Override
	public void add(Paircurrency p) {
		manager.persist(p);
		
	}

	@Override
	public void remove(Paircurrency p) {
		manager.remove(findById(p.getId()));
		
	}

	@Override
	public Paircurrency findById(int id) {
		return manager.find(Paircurrency.class,id);
	}

	@Override
	public void update(Paircurrency p) {
		manager.merge(p);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paircurrency> findAll() {
		Query query = manager.createQuery("SELECT p FROM Paircurrency p ");
		return query.getResultList();
	}
	@Override
	public void setEstimation(Paircurrency s,Float e) {
		Query query = manager.createQuery("UPDATE Paircurrency SET estimation = '"+e+"'"+ "WHERE id = '"+s.getId()+"'");
		query.executeUpdate();}

}
