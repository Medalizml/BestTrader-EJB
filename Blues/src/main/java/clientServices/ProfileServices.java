package clientServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Operation;
import tn.esprit.Blues.entities.Quotation;

@Local
public interface ProfileServices {

	public List<Quotation> getMyQuotations(Integer id);
	public Long getNumberOfShares(Integer portfolioId,Integer quotationId);
	public void addOperation(Operation operation);
	
}
