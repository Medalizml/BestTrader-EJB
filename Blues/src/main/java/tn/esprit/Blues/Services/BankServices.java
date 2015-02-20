package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Bank;
@Remote
public interface BankServices {
	public void add(Bank b);

	public void remove(Bank b);

	public Bank findById(int id);

	public void update(Bank b);

	public List<Bank> findAll();

}
