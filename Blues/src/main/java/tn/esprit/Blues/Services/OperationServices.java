package tn.esprit.Blues.Services;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Company;
import tn.esprit.Blues.entities.Customer;
import tn.esprit.Blues.entities.Operation;


@Remote

public interface OperationServices {
	
	List<Operation> affiche(int i);
	List<Company> affiche1();
}
