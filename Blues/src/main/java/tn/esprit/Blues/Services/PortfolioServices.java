package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Portfolio;
@Remote
public interface PortfolioServices {
	
	public  List<Portfolio> findAllP() ;
		
	

}
