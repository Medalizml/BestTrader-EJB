package ScreenersServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;




import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Company;




@Stateless
public class ScreenersServicesImpl implements ScreenersServices{
	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Date> findAllDate(int id) {
		TypedQuery<Date> query = manager
				.createQuery(
						"select p.time from Pricehistory p where p.quotation.id=:id  ",
						Date.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAllPrivate() {
		Query query = manager.createQuery("SELECT c FROM Company c where c.nature = 'private' ");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAllPublic() {
		Query query = manager.createQuery("SELECT c FROM Company c where c.nature = 'public' ");
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> findAllBank() {
		Query query = manager.createQuery("SELECT c FROM Bank c  ");
		return query.getResultList();
	
	}
	

	@Override
	public List<Float> findAllPrice(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.opningPrice from Pricehistory p  where p.quotation.id=:id ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
	
	@Override
	public List<Float> findAllClosePrice(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.closingPrice from Pricehistory p where p.quotation.id=:id ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
	
	@Override
	public List<Float> findAllLowPrice(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.lowestPrice from Pricehistory p where p.quotation.id=:id ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
	
	@Override
	public List<Float> findAllHighPrice(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.highestPrice from Pricehistory p where p.quotation.id=:id ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
	
	@Override
	public List<Float> findAllVolume(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.volume from Pricehistory p where p.quotation.id=:id ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
}
