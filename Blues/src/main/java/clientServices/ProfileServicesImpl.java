package clientServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.Blues.entities.Operation;
import tn.esprit.Blues.entities.Quotation;

@Stateless
public class ProfileServicesImpl implements ProfileServices {

	@PersistenceContext(name = "Blues")
	EntityManager manager;

	@Override
	public List<Quotation> getMyQuotations(Integer id) {

		TypedQuery<Quotation> query = manager
				.createQuery(
						"select DISTINCT p.quotation from Operation p where p.portfolio.id=:id ",
						Quotation.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@Override
	public Long getNumberOfShares(Integer portfolioId, Integer quotationId) {
	TypedQuery<Long> query = 
			manager.createQuery("select Sum(p.numberShares) from Operation p where p.portfolio.id=:id1 and p.quotation.id=:id2 ",
					Long.class);
		query.setParameter("id1", portfolioId);
		query.setParameter("id2", quotationId);
		return query.getSingleResult();
	}

	@Override
	public void addOperation(Operation operation) {
		manager.persist(operation);
		
	}
}
