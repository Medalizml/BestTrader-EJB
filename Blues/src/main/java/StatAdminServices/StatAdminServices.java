package StatAdminServices;

import java.util.List;

import javax.ejb.Local;

@Local
public interface StatAdminServices {
	public List<Float> findBenefice(int id);
	public List<Integer> findBuy(int id);
	public List<Integer> findSell(int id);
	public List<Float> findPriceBuy(int id);
	public List<Float> findPriceSell(int id) ;
	public List<Float> findPrice(int id);
	public List<Integer> findNumberShares(int id);
}
