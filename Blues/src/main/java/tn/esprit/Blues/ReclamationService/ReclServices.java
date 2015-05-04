package tn.esprit.Blues.ReclamationService;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Reclamation;

@Local
public interface ReclServices {
	public List<Reclamation> findAll(Customer customer);
	public void remove(Reclamation r);
	public Reclamation findById(int id);
	public long numberRec();
	public void addReclamation(Reclamation r);
	public List<Reclamation> findAll();
}
