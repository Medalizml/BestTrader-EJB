package tn.esprit.Blues.EjbTimer;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Share;


@Local
public interface ParserServices {
	
	public Company findCompanyByName(String name);
	public Company findById(int id);
	public void update(Share s);
	public String readhtml();

}
