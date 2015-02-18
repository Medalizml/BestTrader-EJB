package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



//import tn.esprit.Blues.entities.Quotation;
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
	

}
