package tn.esprit.Blues.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the sector database table.
 * 
 */
@Entity
@NamedQuery(name = "Sector.findAll", query = "SELECT s FROM Sector s")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	private List<Company> companies;
	private Indexmarket indexmarket;

	public Sector() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "sector")
	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setSector(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setSector(null);

		return company;
	}

	@OneToOne
	public Indexmarket getIndexmarket() {
		return this.indexmarket;
	}

	public void setIndexmarket(Indexmarket indexmarket) {
		this.indexmarket = indexmarket;
	}

	@Override
	public String toString() {
		return "Sector [id=" + id + ", name=" + name + ","
				 + ", indexmarket=" + indexmarket + "]";
	}
	

}