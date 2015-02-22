package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Paircurrency;


@Remote
public interface PaircurrencyServices {
	public void add(Paircurrency p);
	public void remove(Paircurrency p);
	public Paircurrency findById(int id);
	public void update(Paircurrency p);
	public List<Paircurrency> findAll();
	public void setEstimation(Paircurrency s,Float e);
}
