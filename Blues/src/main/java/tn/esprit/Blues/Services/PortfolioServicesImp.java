package tn.esprit.Blues.Services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.Blues.entities.Portfolio;


@Stateless
public class PortfolioServicesImp implements PortfolioServices{
	
	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	public void updatePortfolio(Portfolio p){
		manager.merge(p);
	}

	@Override
	public Portfolio findById(int id) {
		return manager.find(Portfolio.class,id);
		
	}

	

}
