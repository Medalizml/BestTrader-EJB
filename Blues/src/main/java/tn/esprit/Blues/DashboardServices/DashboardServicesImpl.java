package tn.esprit.Blues.DashboardServices;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Article;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Portfolio;


@Stateless
public class DashboardServicesImpl  implements DashboardServices{
	
	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() {
		Query query = manager.createQuery("SELECT c FROM Company c ORDER BY c.quotation.estimation DESC");
		query.setMaxResults(4);

		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getInactifs(){
		Query query = manager.createQuery("SELECT u FROM Customer u WHERE u.active IS FALSE ");
		query.setMaxResults(2);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Portfolio> getRanking() {
		Query query = manager.createQuery("SELECT u FROM Portfolio u ORDER BY u.gain DESC");
		query.setMaxResults(3);
		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticle() {
		Query query = manager.createQuery("SELECT u FROM Article u ");
		return query.getResultList();
		
	}
}
