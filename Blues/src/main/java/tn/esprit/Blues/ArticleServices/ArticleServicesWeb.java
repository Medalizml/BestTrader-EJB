package tn.esprit.Blues.ArticleServices;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Blues.entities.Article;

@Local
public interface ArticleServicesWeb {
	public void add(Article a);
	public void remove(Article a);
	public Article findById(int id);
	public void update(Article a);
	public List<Article> findAll();
	public Article lastOne();
}
