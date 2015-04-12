package Bank;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Bond;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Currency;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Quotation;
import tn.esprit.Blues.entities.Sector;
import tn.esprit.Blues.entities.Share;

@Stateless
public class BankServiceImp implements BankService{
	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	
	@Override
	public void add(Bank b,Quotation q) {
		manager.persist(b);
		manager.persist(q);
		
	}

	@Override
	public void remove(Bank a) {
		manager.remove(findById(a.getId()));
		
	}

	@Override
	public Bank findById(int id) {
		return manager.find(Bank.class,id);
		
	}

	@Override
	public void update(Bank c,Share s) {
		// TODO Auto-generated method stub
		manager.merge(c);
		manager.merge(s);
	}

	

	@Override
	public List<Bank> findAllBank() {
		Query query = manager.createQuery("SELECT c FROM Bank c  ");
		return query.getResultList();
	
	}

	

	
	
		
	

	
	

	@Override
	public List<Currencybank> findBybank(int id) {
		Query query = manager.createQuery("SELECT c FROM Currencybank c WHERE c.bank.id = '"+id+"'");
		return query.getResultList();
	}
	@Override
	public Currencybank findByCurrId(int id) {
		return manager.find(Currencybank.class,id);
	}
	@Override
	public void removeCurr(Currencybank currencybank) {
		manager.remove(findByCurrId(currencybank.getId()));
		
	}

	@Override
	public List<Currency> FindAll() {
		Query query = manager.createQuery("SELECT c FROM Currency c");
		return query.getResultList();
	}

	@Override
	public void addCurrencyBank(Currencybank currencybank) {
		manager.persist(currencybank);
		
	}

	@Override
	public Currency FindCurrById(int i) {
		return manager.find(Currency.class,i);
	}

	@Override
	public void updateCu(Currencybank currencybank) {
		manager.merge(currencybank);
		
	}

	

	
	
	
	

	

}
