package clientServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Share;


@Local
public interface QuotationsServices {

	public List<Share> getQuot();
}
