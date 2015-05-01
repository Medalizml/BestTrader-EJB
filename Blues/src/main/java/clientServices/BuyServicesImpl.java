package clientServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Share;


@Stateless
public class BuyServicesImpl implements BuyServices {
	
	@PersistenceContext(name="Blues")
	EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Share> getShares() {
		Query query = manager.createQuery("SELECT s FROM Share s WHERE s.closingPrice>'"+0+"'");
		return query.getResultList();
	}

}
