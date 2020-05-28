package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mot database table.
 * 
 */
@Entity
@NamedQuery(name="Mot.findAll", query="SELECT m FROM Mot m")
public class Mot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String mot;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categorie")
	private Categorie categorieBean;

	public Mot() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMot() {
		return this.mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public Categorie getCategorieBean() {
		return this.categorieBean;
	}

	public void setCategorieBean(Categorie categorieBean) {
		this.categorieBean = categorieBean;
	}

}