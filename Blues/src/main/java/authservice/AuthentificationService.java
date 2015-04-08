package authservice;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.Blues.entities.Administrator;

@Stateless
public class AuthentificationService implements AuthentificationServiceI {
	@PersistenceContext
	EntityManager em;

	@Override
	public Administrator authentificate(String email, String password) {
		String query = String.format("select u from Administrator u where u.email = '%s' and u.password = '%s'", email, password);
		System.out.println("B");
		Administrator admins = (Administrator) em.createQuery(query).getSingleResult();
		return admins;
	}

	@Override
	public Administrator getAdminByUser(int id) {
		
		return em.find(Administrator.class, id);
	}
	

}
