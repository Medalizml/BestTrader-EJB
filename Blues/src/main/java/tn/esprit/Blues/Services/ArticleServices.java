package tn.esprit.Blues.Services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Blues.entities.Article;
@Remote


public interface ArticleServices {

	
	public void add(Article a);
	public void remove(Article a);
	public Article findById(int id);
	public void update(Article a);
	public List<Article> findAll();
	public Article lastOne();

}
