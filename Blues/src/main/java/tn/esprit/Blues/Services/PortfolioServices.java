package tn.esprit.Blues.Services;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Portfolio;

@Remote
public interface PortfolioServices {
	
	
	public void updatePortfolio(Portfolio p);
	public Portfolio findById(int id);

}
