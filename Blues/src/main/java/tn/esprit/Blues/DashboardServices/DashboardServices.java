package tn.esprit.Blues.DashboardServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Article;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;
@Local
public interface DashboardServices {

	
	public List<Customer> getInactifs();
	public List<Portfolio> getRanking();
	public List<Company> findAll();
	public List<Article> getArticle();

}
