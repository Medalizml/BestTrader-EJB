package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.Blues.entities.Company;
@Stateless
public class CompanyServicesImpl implements CompanyServices {
	@PersistenceContext(name="Blues")
	EntityManager manager;
	@Override
	public void add(Company c) {
		manager.persist(c);
		
	}

	@Override
	public void remove(Company c) {
		manager.remove(findById(c.getId()));
		
	}

	@Override
	public Company findById(int id) {
		return manager.find(Company.class,id);
	}

	@Override
	public void update(Company c) {
		manager.merge(c);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() {
		Query query = manager.createQuery("SELECT c FROM Company c ");
		return query.getResultList();
	}

	@Override
	public Company findCompanyByName(String name) {
		Query query = manager.createQuery("SELECT c FROM Company c WHERE c.name = '"+name+"'");
		return (Company) query.getSingleResult();
	}
}
