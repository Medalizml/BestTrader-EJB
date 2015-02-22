package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Bond;
/**
 * 
 * @author Maleck
 *
 */
@Stateless
public class BondServicesImpl implements BondServices {
	@PersistenceContext(name = "Blues")
	EntityManager manager;

	@Override
	public void add(Bond b) {
		manager.persist(b);
	}

	@Override
	public void remove(Bond b) {
		manager.remove(findById(b.getId()));

	}

	@Override
	public Bond findById(int id) {
		return manager.find(Bond.class, id);
	}

	@Override
	public void update(Bond b) {
		manager.merge(b);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bond> findAll() {
		Query query = manager.createQuery("SELECT u FROM Bond u");
		return query.getResultList();
	}
	@Override
	public void setEstimation(Bond s,Float e) {
		Query query = manager.createQuery("UPDATE Bond SET estimation = '"+e+"'"+ "WHERE id = '"+s.getId()+"'");
		query.executeUpdate();
		
	}

}
