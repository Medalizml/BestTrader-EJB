package tn.esprit.Blues.Services;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Operation;

@Stateless

public class OperationServices implements OperationServicesInterface {
	@PersistenceContext(name="Blues")
	EntityManager em;
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> afficherOperation() {
		Query query = em.createQuery("SELECT o FROM Operation o");
		return query.getResultList();
	}
	
	
	

	

}
