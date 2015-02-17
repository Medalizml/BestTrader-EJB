package tn.esprit.Blues.Services;

import java.util.List;

import tn.esprit.Blues.entities.Quotation;
import tn.esprit.Blues.entities.Share;

public interface SharesServices {
	public void add(Share s);

	public void remove(Share s);

	public Share findById(int id);

	public void update(Share s);

	public List<Quotation> findAll();

}
