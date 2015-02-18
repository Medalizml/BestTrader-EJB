package tn.esprit.Blues.Services;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Operation;


@Remote

public interface OperationServicesInterface {
	List<Operation> afficherOperation();
	
	
}
