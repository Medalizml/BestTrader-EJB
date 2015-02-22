package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Share;
/**
 * 
 * @author Maleck
 *
 */
@Stateless
public class SharesServicesImpl implements SharesServices {
	@PersistenceContext(name = "Blues")
	EntityManager manager;

	@Override
	public void add(Share s) {
		manager.persist(s);

	}

	@Override
	public void remove(Share s) {
		manager.remove(findById(s.getId()));

	}

	@Override
	public Share findById(int id) {
		return manager.find(Share.class, id);
	}

	@Override
	public void update(Share s) {
		manager.merge(s);

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Share> findAll() {
		//Query query = manager.createQuery("SELECT c.name, c.logo, q.closingPrice, q.estimation FROM quotation q inner join company c on c.id=q.company_id");
		Query query = manager.createQuery("SELECT s FROM Share s");
		return query.getResultList();
		
	}

	@Override
	public void setEstimation(Share s,Float e) {
		Query query = manager.createQuery("UPDATE Share SET estimation = '"+e+"'"+ "WHERE id = '"+s.getId()+"'");
		query.executeUpdate();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> Sharestab() {
		/*int id=10;
		Query query = manager.createQuery("SELECT s.company FROM Share s where s.id=:id ");
		query.setParameter("id",id);
		Company c=(Company)query.getSingleResult();
		Query q2=manager.createQuery("SELECT c FROM Company c WHERE c.id=:idc");
		q2.setParameter("idc",c.getId());
		return (Company)q2.getSingleResult();*/
		Query query = manager.createQuery("SELECT q.company FROM Quotation q");
		return query.getResultList();
	}

}
