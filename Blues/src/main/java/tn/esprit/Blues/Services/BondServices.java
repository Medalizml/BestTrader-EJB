package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Bond;
@Remote
public interface BondServices {
	public void add(Bond b);

	public void remove(Bond b);

	public Bond findById(int id);

	public void update(Bond b);

	public List<Bond> findAll();
	public void setEstimation(Bond s,Float e);
}
