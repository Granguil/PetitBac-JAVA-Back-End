package com.example.demo.Response;

public class ScoreResponse {
	
	private int id;

	private int accepte;
	
	private int enAttente;

	private int nbPartie;

	private String pseudo;

	private int refuse;

	private int score;

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
