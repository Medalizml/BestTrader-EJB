package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Sector;

@Remote
public interface SectorServices {
	public void add(Sector s);
	public void remove(Sector s);
	public Sector findById(int id);
	public void update(Sector s);
	public List<Sector> findAll();
}
