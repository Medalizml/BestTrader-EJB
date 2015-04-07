package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Article;
import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Currency;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Share;

@Stateless
public class BankShareServicesImp implements BankShareServices{
	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	@Override
	public void add(Bank b,Share s) {
		manager.persist(b);
		manager.persist(s);
		
		
		
	}

	@Override
	public void remove(Bank b) {
		
		
	}

	

	@Override
	public void update(Bank b,Share s) {
		manager.merge(b);
		manager.merge(s);
		
	}

	

	@Override
	public void addCurrency(Currency c,Currencybank currencybank) {
		manager.persist(c);
		manager.persist(currencybank);
		
	}
	
	@Override
	public List<Bank> findAll() {
		Query query = manager.createQuery("SELECT b FROM Bank b ");
		return query.getResultList();
		
	}
	public Bank findById(int id) {
		return manager.find(Bank.class,id);
		
	}

	@Override
	public void editCurrency(Currencybank cb) {
		manager.merge(cb);
		
	}
	
}
