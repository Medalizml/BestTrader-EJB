package clientServices;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Article;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Sector;

@Stateless
public class homeServicesImpl implements homeServices{

	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticle() {
		Query query = manager.createQuery("SELECT u FROM Article u ");
		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAllCompanies() {
		Query query = manager.createQuery("SELECT c FROM Company c ");

		return query.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sector> findAllSectors() {
		Query query = manager.createQuery("SELECT c FROM Sector c ");
		return query.getResultList();
	}

	@Override
	public List<Long> nbrCompanyBySector() {
		List<Long> l = new ArrayList<Long>();
		
		for (int i = 1; i < 14; i++) {
			
		
		Query query = manager.createQuery("SELECT count(c) FROM Company c where c.sector.id = '"+i+"' ");
		
		l.add((Long) query.getSingleResult());
		
		
		}
		return l;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findCompaniesPositivEstimation() {
		Query query = manager.createQuery("SELECT c FROM Company c ORDER BY c.quotation.estimation DESC");
		query.setMaxResults(6);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findCompaniesNegativEstimation() {
		Query query = manager.createQuery("SELECT c FROM Company c ORDER BY c.quotation.estimation");
		query.setMaxResults(6);

		return query.getResultList();
	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Company> findPrivateCompanies() {
		Query query = manager.createQuery("SELECT c FROM Company c where c.nature = 'private' ORDER BY c.quotation.closingPrice DESC");
		query.setMaxResults(6);

		return query.getResultList();
	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Company> findPublicCompanies() {
		Query query = manager.createQuery("SELECT c FROM Company c where c.nature = 'public' ORDER BY c.quotation.closingPrice DESC");
		query.setMaxResults(6);

		return query.getResultList();
	}
	@SuppressWarnings("unchecked")

	@Override
	public List<Company> findBanks() {
		Query query = manager.createQuery("SELECT c FROM Company c where c.nature = 'Bank' ORDER BY c.quotation.closingPrice DESC");
		query.setMaxResults(6);

		return query.getResultList();
	}
}
