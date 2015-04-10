package privateCompany;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Bond;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Quotation;
import tn.esprit.Blues.entities.Sector;
import tn.esprit.Blues.entities.Share;

@Stateless
public class PrivateCompanyServiceImp implements PrivateCompnayService{
	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	
	@Override
	public void add(Company c,Quotation q) {
		manager.persist(c);
		manager.persist(q);
		
	}

	@Override
	public void remove(Company a) {
		manager.remove(a);
		
	}

	@Override
	public Company findById(int id) {
		return manager.find(Company.class,id);
		
	}

	@Override
	public void update(Company c,Share s) {
		// TODO Auto-generated method stub
		manager.merge(c);
		manager.merge(s);
	}

	

	@Override
	public List<Company> findAllPublic() {
		Query query = manager.createQuery("SELECT c FROM Company c where c.nature = 'public' ");
		return query.getResultList();
	
	}

	@Override
	public List<Company> findAllPrivate() {
		Query query = manager.createQuery("SELECT c FROM Company c where c.nature = 'private' ");
		return query.getResultList();
	}

	@Override
	public List<Sector> findAllSector() {
		Query query = manager.createQuery("SELECT s FROM Sector s ");
		return query.getResultList();
		
	}
	public  void updatePublic(Company c,Bond b){
		manager.merge(c);
		manager.merge(b);
		
		
	}

	@Override
	public void addBond(Bond b) {
		manager.merge(b);
		
	}

	@Override
	public List<Currencybank> findBybank(int id) {
		Query query = manager.createQuery("SELECT c FROM Currencybank c WHERE c.bank.id = '"+id+"'");
		return query.getResultList();
	}

}
