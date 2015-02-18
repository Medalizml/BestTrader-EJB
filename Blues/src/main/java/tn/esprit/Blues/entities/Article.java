package tn.esprit.Blues.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the article database table.
 * 
 */
@Entity

public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String author;
	private Date date;
	private String name;
	private String picture;
	private String topic;
	
	private Administrator administrator;

	public Article() {
	}


	public Article(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}


	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	public Administrator getAdministrator() {
		return administrator;
	}


	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}


	

}