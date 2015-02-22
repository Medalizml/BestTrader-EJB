package tn.esprit.Blues.Services;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Administrator;
/**
 * 
 * @author Omar
 * Ceci est le contrat de service de l'"interface métier" ILoginRemote.
 * Contient un service "authentification"
 *
 */
@Remote
public interface ILoginRemote {
	
	//public void sayHello();
	public Administrator authentification(String email,String password);

}
