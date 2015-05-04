package authservice;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import tn.esprit.Blues.entities.Administrator;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.User;

@Stateless
public class AuthentificationService implements AuthentificationServiceI {
	@PersistenceContext
	EntityManager em;

	@Override
	public User authentificate(String email, String password) {
		User admins =null;
		String query = String.format("select u from User u where u.email = '%s' and u.password = '%s'", email, password);
		System.out.println("B");
		try{
		admins =(User)em.createQuery(query).getSingleResult();}
		catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println("hhhhhhhhhhhh");
			
		}
		return admins;
	}

	@Override
	public Administrator getAdminByUser(int id) {
		
		return em.find(Administrator.class, id);
	}

	@Override
	public Customer getClientByuser(int id) {
		// TODO Auto-generated method stub
		return em.find(Customer.class, id);
	}
	

}
