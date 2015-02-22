package tn.esprit.Blues.Services;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Operation;

@Stateless

public class OperationServicesImpl implements OperationServices {
	@PersistenceContext(name="Blues")
	EntityManager em;
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> affiche(int i) {
		String query=String.format("Select o from Operation o where o.portfolio.customer.id='%d'",i);
	Query  q=em.createQuery(query);

	return q.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Company> affiche1() {
		
Query query = em.createQuery("SELECT c FROM Company c");
		
		return query.getResultList();
	}


}
