package tn.esprit.Blues.Services;


import javax.ejb.Stateless;


import tn.esprit.Blues.Services.ILoginRemote;
import tn.esprit.Blues.entities.Administrator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB est une spécification
 			Ceci est notrz EJB.les EJB sont deux types ; les sessions Bean et les Message Driven Bean.
 					Les Session Bean sont trois type Statless,Staful,Singleton.
 					Les Sessions Bean admettent deux tyes d'accés; Remote et Local.
 					Cet EJB de type Session Bean permet de retourner une salutation lorssqu'un client la réclame .	
 */

/**
 * Session Bean implementation class Greetings
 */
@Stateless
public class LoginService implements ILoginRemote {
	@PersistenceContext(name="Blues")
	private EntityManager em;

	
	public LoginService() {
		
	}

	@Override
	public Administrator authentification(String email, String password) {
		// TODO Auto-generated method stub
		String query = String.format("select u from Administrator u where u.email = '%s' and u.password = '%s'", email, password);
		System.out.println("B");
		Administrator admins = (Administrator) em.createQuery(query).getSingleResult();
		return admins;
	}

	

}
