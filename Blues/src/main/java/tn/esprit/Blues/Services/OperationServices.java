package tn.esprit.Blues.Services;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.Blues.entities.Operation;

public class OperationServices implements OperationServicesInterface {
	
	
	@PersistenceContext(name="Blues")
	EntityManager em;

	@Override
	public List<Operation> afficherOperation() {
		 TypedQuery<Operation> query =
				    em.createQuery("SELECT o FROM operation o", Operation.class);
				  List<Operation> results = (List<Operation>)query.getResultList();
		return null;
	}
	

	

}
