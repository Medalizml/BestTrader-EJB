package tn.esprit.Blues.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import tn.esprit.Blues.entities.User;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
@DiscriminatorValue(value="admin")
public class Administrator extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private List<Article> articles;
	
	
@OneToMany(mappedBy="administrator")
	public List<Article> getArticles() {
		return articles;
	}



	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}



	public Administrator() {
		super();
	}
   
}
