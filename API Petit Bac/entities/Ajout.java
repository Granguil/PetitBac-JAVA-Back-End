package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ajout database table.
 * 
 */
@Entity
@NamedQuery(name="Ajout.findAll", query="SELECT a FROM Ajout a")
public class Ajout implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String mot;

	private String pseudo;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	@JoinColumn(name="categorie")
	private Categorie categorieBean;

	public Ajout() {
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

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Categorie getCategorieBean() {
		return this.categorieBean;
	}

	public void setCategorieBean(Categorie categorieBean) {
		this.categorieBean = categorieBean;
	}

}