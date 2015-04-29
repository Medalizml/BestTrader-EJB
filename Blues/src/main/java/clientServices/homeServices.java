package clientServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Article;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Sector;

@Local
public interface homeServices {
	public List<Article> getArticle();
	public List<Company> findAllCompanies();
	public List<Sector> findAllSectors();
	public List<Long> nbrCompanyBySector();
	public List<Company> findCompaniesPositivEstimation();
	public List<Company> findCompaniesNegativEstimation();
	public List<Company> findPrivateCompanies();
	public List<Company> findPublicCompanies();
	public List<Company> findBanks();

}
