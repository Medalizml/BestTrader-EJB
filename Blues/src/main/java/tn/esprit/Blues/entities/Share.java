package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import tn.esprit.Blues.entities.Quotation;

/**
 * Entity implementation class for Entity: Share
 *
 */
@Entity

public class Share extends Quotation implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Share() {
		super();
	}

	@Override
	public String toString() {
		return "Share [getId()=" + getId() + ", getClosingPrice()="
				+ getClosingPrice() ;
	}
   
}
