package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;




import tn.esprit.Blues.entities.Portfolio;
@Stateless
public class PortfolioServicesImpl implements PortfolioServices {
	
	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Portfolio> findAllP() {
		Query query = manager.createQuery("SELECT p FROM Portfolio p  ");
		return query.getResultList();
	}
}
