package tn.esprit.Blues.EstimationService;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Quotation;
import tn.esprit.Blues.entities.Share;

@Stateless
public class EstimServicesImpl implements EstimServices{

	@PersistenceContext(name="Blues")
	EntityManager manager;

	public List<Company> findAll() {
		Query query = manager.createQuery("SELECT c FROM Company c");
		return query.getResultList();
		
	}
	@Override
	public void updateEstimation(Quotation q) {
		/*Query query = manager.createQuery("UPDATE Quotation SET estimation = '"+e+"'"+ "WHERE id = '"+q.getId()+"'");
		query.executeUpdate();
		*/
		manager.merge(q);
	}
}
