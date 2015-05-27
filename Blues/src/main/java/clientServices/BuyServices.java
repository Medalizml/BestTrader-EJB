package clientServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Share;


@Local
public interface BuyServices {

	public List<Share> getShares();
}
