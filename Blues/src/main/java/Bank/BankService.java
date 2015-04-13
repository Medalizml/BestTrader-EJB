package Bank;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Currency;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Quotation;
import tn.esprit.Blues.entities.Share;

@Local
public interface BankService {

	public void add(Bank b, Quotation q);

	public void remove(Bank b);

	public Company findById(int id);

	public void update(Bank b, Share s);

	public void removeCurr(Currencybank currencybank);

	public Currencybank findByCurrId(int id);

	public List<tn.esprit.Blues.entities.Currency> FindAll();

	public List<Bank> findAllBank();

	public List<Currencybank> findBybank(int id);
	
	public void addCurrencyBank(Currencybank currencybank);
	public Currency FindCurrById(int i);
	public void updateCu(Currencybank currencybank);

}
