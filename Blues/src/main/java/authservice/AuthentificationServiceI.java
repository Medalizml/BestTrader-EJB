package authservice;


import javax.ejb.Local;


import tn.esprit.Blues.entities.Administrator;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.User;

@Local
public interface AuthentificationServiceI {

	
	public User authentificate(String email, String password);
	public Administrator getAdminByUser(int id);
	public Customer getClientByuser(int id);
}
