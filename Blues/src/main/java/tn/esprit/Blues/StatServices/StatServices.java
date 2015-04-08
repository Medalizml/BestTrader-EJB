package tn.esprit.Blues.StatServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Customer;


@Local
public interface StatServices {
	public String getName();
	public List<Customer> getList();


}
