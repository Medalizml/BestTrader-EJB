package StatAdminServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



@Stateless
public class StatAdminImpl implements StatAdminServices{
	
	@PersistenceContext
	EntityManager manager;
	
	@Override
	public List<Float> findBenefice(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.gain from Portfolio p  where p.id=:id ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
	
	@Override
	public List<Integer> findBuy(int id) {
		TypedQuery<Integer> query = manager
				.createQuery(
						"select p.numberShares from Operation p  where p.portfolio.id=:id AND p.numberShares>0  ",
						Integer.class);
		query.setParameter("id",id);
		return query.getResultList();
		

	}
	
	@Override
	public List<Integer> findSell(int id) {
		TypedQuery<Integer> query = manager
				.createQuery(
						"select ABS(p.numberShares) from Operation p  where p.portfolio.id=:id AND p.numberShares<0  ",
						Integer.class);
		query.setParameter("id",id);
		return query.getResultList();
		

	}
	
	@Override
	public List<Float> findPriceBuy(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.sharePrice from Operation p  where p.portfolio.id=:id  AND p.numberShares>0 ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();
		

	}
	
	@Override
	public List<Float> findPriceSell(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.sharePrice from Operation p  where p.portfolio.id=:id  AND p.numberShares<0 ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();
		

	}
	
	@Override
	public List<Float> findPrice(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.sharePrice from Operation p  where p.portfolio.id=:id ",
						Float.class);
		query.setParameter("id",id);
		return query.getResultList();
		

	}
	
	@Override
	public List<Integer> findNumberShares(int id) {
		TypedQuery<Integer> query = manager
				.createQuery(
						"select p.numberShares from Operation p  where p.portfolio.id=:id ",
						Integer.class);
		query.setParameter("id",id);
		return query.getResultList();
		

	}

}
