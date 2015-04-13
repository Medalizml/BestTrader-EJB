package tn.esprit.Blues.ArticleServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.Blues.entities.Article;
@Stateless
public class ArticleServicesImplWeb implements ArticleServicesWeb {

	@PersistenceContext(name="Blues")
	EntityManager manager;
	
	@Override
	public void add(Article a) {
		manager.persist(a);
		
	}

	@Override
	public void remove(Article a) {
		manager.remove(findById(a.getId()));;
		
	}

	@Override
	public Article findById(int id) {
		return manager.find(Article.class,id);
		
	}

	@Override
	public void update(Article a) {
		manager.merge(a);
		
	}

	@Override
	public List<Article> findAll() {
		Query query = manager.createQuery("SELECT u FROM Article u");
		return query.getResultList();

	}

	@Override
	public Article lastOne() {
		
		Query query = manager.createQuery("SELECT u.id FROM Article u");
		List<Integer> l = query.getResultList();
		Integer max=0;
		for (Integer integer : l) {
			
			if (integer>max)
				max=integer;
			
		}
		System.out.println(max);
		return findById(max);
	
	}
	
	

}
