package tn.esprit.Blues.EstimationService;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Quotation;
import tn.esprit.Blues.entities.Share;

@Local
public interface EstimServices {

	public void updateEstimation(Quotation q);
	public List<Company> findAll();
}
