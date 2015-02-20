package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;
import tn.esprit.Blues.entities.Indexmarket;

@Remote
public interface IndexmarketServices {
	public void add(Indexmarket i);
	public void remove(Indexmarket i);
	public Indexmarket findById(int id);
	public void update(Indexmarket i);
	public List<Indexmarket> findAll();
}
