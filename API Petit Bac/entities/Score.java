package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the score database table.
 * 
 */
@Entity
@NamedQuery(name="Score.findAll", query="SELECT s FROM Score s")
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int accepte;

	@Column(name="en_attente")
	private int enAttente;


	@Column(name="nb_partie")
	private int nbPartie;

	private String pseudo;

	private int refuse;

	private int score;



	public Score() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccepte() {
		return this.accepte;
	}

	public void setAccepte(int accepte) {
		this.accepte = accepte;
	}

	public int getEnAttente() {
		return this.enAttente;
	}

	public void setEnAttente(int enAttente) {
		this.enAttente = enAttente;
	}


	public int getNbPartie() {
		return this.nbPartie;
	}

	public void setNbPartie(int nbPartie) {
		this.nbPartie = nbPartie;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	

	public int getRefuse() {
		return this.refuse;
	}

	public void setRefuse(int refuse) {
		this.refuse = refuse;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	

}