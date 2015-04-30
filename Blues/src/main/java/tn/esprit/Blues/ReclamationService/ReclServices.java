package tn.esprit.Blues.ReclamationService;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Reclamation;

@Local
public interface ReclServices {
	public List<Reclamation> findAll();
	public void remove(Reclamation r);
	public Reclamation findById(int id);
	public long numberRec();
}
