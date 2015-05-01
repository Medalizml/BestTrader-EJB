package clientServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.Blues.entities.Company;

@Stateless
public class SectorServicesImple implements SectorServices{

	@PersistenceContext(name="Blues")
	EntityManager manager;

	@Override
	public List<Company> findCompaniesBySector(Integer id) {
		TypedQuery<Company> query = manager.createQuery(
						"select p from Company p where p.sector.id=:id ",
						Company.class);
		query.setParameter("id",id);
		return query.getResultList();

	}
	
}
