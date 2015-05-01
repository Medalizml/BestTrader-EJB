package clientServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Share;


@Stateless
public class QuotationServiceImpl implements QuotationsServices{
	@PersistenceContext(name="Blues")
	EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Share> getQuot() {
		Query query = manager.createQuery("SELECT s FROM Share s ORDER BY s.company.name");
		return query.getResultList();
	}

}
