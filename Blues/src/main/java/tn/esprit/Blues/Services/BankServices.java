package tn.esprit.Blues.Services;

import java.util.List;

import tn.esprit.Blues.entities.Bank;

public interface BankServices {
	public void add(Bank b);

	public void remove(Bank b);

	public Bank findById(int id);

	public void update(Bank b);

	public List<Bank> findAll();

}
