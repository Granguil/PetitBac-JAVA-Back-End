package com.example.demo.utils;

import com.example.demo.Response.AjoutResponse;
import com.example.demo.Response.MotResponse;
import com.example.demo.Response.ScoreResponse;
import com.example.demo.entities.Ajout;
import com.example.demo.entities.Mot;
import com.example.demo.entities.Score;

public class ModelMapper {
	
	
	public static ScoreResponse mapScoreToScoreResponse(Score score) {
		ScoreResponse response = new ScoreResponse();
		response.setId(score.getId());
		response.setAccepte(score.getAccepte());
		response.setEnAttente(score.getEnAttente());
		response.setNbPartie(score.getNbPartie());
		response.setPseudo(score.getPseudo());
		response.setRefuse(score.getRefuse());
		response.setScore(score.getScore());
		return response;
	}
	
	public static MotResponse mapMotToMotResponse(Mot mot) {
		MotResponse response=new MotResponse();
		response.setId(mot.getId());
		response.setCategorieBean(mot.getCategorieBean());
		response.setMot(mot.getMot());
		return response;
	}
	
	public static AjoutResponse mapAjoutToAjoutResponse(Ajout ajout) {
		AjoutResponse response=new AjoutResponse();
		response.setId(ajout.getId());
		response.setCategorieBean(ajout.getCategorieBean());
		response.setMot(ajout.getMot());
		response.setPseudo(ajout.getPseudo());
		return response;
	}
}

