package tn.esprit.Blues.Services;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Share;
@Remote
public interface SharesServices {
	public void add(Share s);

	public void remove(Share s);

	public Share findById(int id);

	public void update(Share s);
	
	public void setEstimation(Share s,Float e);

	public List<Share> findAll();
	
	
	public List<Company> Sharestab();

}
