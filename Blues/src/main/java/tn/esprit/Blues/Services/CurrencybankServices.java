package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Currencybank;


@Remote
public interface CurrencybankServices {
	public void add(Currencybank c);
	public void remove(Currencybank c);
	public Currencybank findById(int id);
	public void update(Currencybank c);
	public List<Currencybank> findAll();
	public List<Currencybank> findByid(int i);

}