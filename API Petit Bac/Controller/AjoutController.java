package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.AjoutRepository;
import com.example.demo.Repository.ScoreRepository;
import com.example.demo.Request.AjoutRequest;
import com.example.demo.Response.AjoutResponse;
import com.example.demo.Service.AjoutService;
import com.example.demo.entities.Ajout;
import com.example.demo.entities.Score;

@RestController
@RequestMapping("/Ajout")
public class AjoutController {
@Autowired
AjoutRepository ajoutRepository;

@Autowired
ScoreRepository scoreRepository;

@Autowired
private AjoutService ajoutService;

@CrossOrigin(origins="*")
@GetMapping("/all")
public List<AjoutResponse> getAll(){
	List<AjoutResponse> liste=ajoutService.findAllAjout();
	return liste;
}

@CrossOrigin(origins="*")
@PostMapping("/add")
public void add(@Validated @RequestBody AjoutRequest ajoutRequest){
	Ajout ajout=new Ajout();
	ajout.setMot(ajoutRequest.getMot());
	ajout.setCategorieBean(ajoutRequest.getCategorieBean());
	ajout.setPseudo(ajoutRequest.getPseudo());
	ajoutRepository.save(ajout);
}

@CrossOrigin(origins="*")
@PostMapping("/maj")
public void maj(@Validated @RequestParam HashMap<String,String> request){
	
	try {
	Ajout ajout=new Ajout();
	ajout=ajoutRepository.findByMotAndCategorieBean_categorieAndPseudo(request.get("mot"),request.get("categorie"), request.get("pseudo")).get();
	ajoutRepository.delete(ajout);
	}catch(Exception e) {
		
	}
	Score score=new Score();
	score=scoreRepository.findByPseudo(request.get("pseudo")).get();
	score.setEnAttente(score.getEnAttente()-1);
	if(request.get("statut").equals("accepte")) {
		score.setAccepte(score.getAccepte()+1);
	}else {
		score.setRefuse(score.getRefuse()+1);
	}
	scoreRepository.save(score);
}
}
