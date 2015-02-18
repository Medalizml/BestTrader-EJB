package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Company;

@Remote
public interface CompanyServices {
	public void add(Company c);
	public void remove(Company c);
	public Company findById(int id);
	public void update(Company c);
	public List<Company> findAll();

}
