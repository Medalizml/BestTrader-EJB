package tn.esprit.Blues.Services;


import java.util.List;

import javax.ejb.Remote;






import tn.esprit.Blues.entities.Bank;
import tn.esprit.Blues.entities.Currency;
import tn.esprit.Blues.entities.Currencybank;
import tn.esprit.Blues.entities.Share;

@Remote
public interface BankShareServices {
	public void add(Bank b,Share s);
	public void remove(Bank a);
	
	public void update(Bank a,Share s);
	public List<Bank> findAll();
	public void addCurrency(Currency c,Currencybank currencybank);
	public Bank findById(int id);
	public void editCurrency(Currencybank cb);


}
