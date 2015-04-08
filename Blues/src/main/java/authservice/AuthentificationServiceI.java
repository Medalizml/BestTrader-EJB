package authservice;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import tn.esprit.Blues.entities.Administrator;
import tn.esprit.Blues.entities.User;

@Local
public interface AuthentificationServiceI {

	
	public User authentificate(String email, String password);
	public Administrator getAdminByUser(int id);
}
