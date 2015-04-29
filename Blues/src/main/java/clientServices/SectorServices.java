package clientServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Company;

@Local
public interface SectorServices {

	public List<Company> findCompaniesBySector(Integer id);
}
