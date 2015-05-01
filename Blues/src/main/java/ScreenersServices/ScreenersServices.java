package ScreenersServices;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Company;


@Local
public interface ScreenersServices {
	
	public List<Date> findAllDate(int id);
	public List<Company> findAllPrivate();
	public List<Company> findAllPublic();
	public List<Bank> findAllBank();
	public List<Float> findAllPrice(int id);
	public List<Float> findAllClosePrice(int id);
	public List<Float> findAllLowPrice(int id);
	public List<Float> findAllHighPrice(int id);

}
