package tn.esprit.Blues.EjbTimer;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.Blues.entities.Company;

@Singleton
@Startup
public class EstimationCalculator {

	@PersistenceContext(name = "Blues")
	EntityManager manager;
	private float estimation;

	public Company findById(int id) {
		return manager.find(Company.class, id);
	}

	public List<Float> findAllClosePrice(int id) {
		TypedQuery<Float> query = manager
				.createQuery(
						"select p.closingPrice from Pricehistory p where p.quotation.id=:id ",
						Float.class);
		query.setParameter("id", id);
		return query.getResultList();

	}

	public void update(Company c) {
		manager.merge(c);

	}

	public List<Company> findAll() {
		Query query = manager.createQuery("SELECT c FROM Company c ");
		return query.getResultList();
	}

	public Float setEstimation(Company company) {
		
		List<Float> prices = findAllClosePrice(company.getId());

		float x = 0;
		float Sxc = 0;
		float Sx;
		int n = prices.size();
		Float mu;
		float sigma;

		for (int i = 0; i < n; i++) {
			x += (prices.get(i) / n);

		}

		for (int i = 0; i < n; i++) {
			Sxc += ((prices.get(i) - x) * (prices.get(i) - x)) / n;
		}
		Sx = (float) Math.sqrt(Sxc);
		mu = (x / 333) + (Sxc / 333);
		sigma = (float) (Sx / Math.sqrt(333));
		estimation = (float) (company.getQuotation().getClosingPrice() * Math
				.exp((mu / 365) + (sigma * sigma / (2 * 365))));
		if(company.getQuotation().getClosingPrice()!=0){
		estimation=(estimation-company.getQuotation().getClosingPrice())*100/company.getQuotation().getClosingPrice();}
		return estimation;
	}
	
	public void updateEst(){
		List<Company> companies=findAll();
		for(int i=0;i<companies.size();i++){
			companies.get(i).getQuotation().setEstimation(setEstimation(companies.get(i)));
			try{
				update(companies.get(i));
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}
	}

	@PostConstruct
	@Schedule(year = "*", dayOfWeek = "*", hour = "*/24", persistent = false)
	public void init() {
		updateEst();
	}

	public float getEstimation() {
		return estimation;
	}

	public void setEstimation(float estimation) {
		this.estimation = estimation;
	}
}
