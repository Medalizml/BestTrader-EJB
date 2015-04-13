package privateCompany;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Bond;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Quotation;
import tn.esprit.Blues.entities.Sector;
import tn.esprit.Blues.entities.Share;

@Local
public interface PrivateCompnayService {
	public void add(Company c,Quotation q);
	public void remove(Company a);
	public Company findById(int id);
	public void update(Company a,Share s);
	public void updatePublic(Company c,Bond b);
	
	public List<Company>  findAllPublic();
	public List<Company> findAllPrivate();
	public List<Sector> findAllSector();
	public void addBond(Bond b);
	public List<Currencybank>findBybank(int id);
	public Sector findSectorByName(String name);
}
