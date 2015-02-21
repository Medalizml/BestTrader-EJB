package tn.esprit.Blues.Services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.Blues.entities.Portfolio;


@Stateless
public class PortfolioServicesImp implements PortfolioServices{
	
	@PersistenceContext(name="Blues")
	EntityManager manage;
	
	public void updatePortfolio(Portfolio p){
		manage.merge(p);
	}

	@Override
	public Portfolio findById(int id) {
		return manage.find(Portfolio.class,id);
		
	}

	

}
