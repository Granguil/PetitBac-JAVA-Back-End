package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.ScoreRepository;
import com.example.demo.Response.ScoreResponse;
import com.example.demo.Service.ScoreService;
import com.example.demo.entities.Score;
import com.example.demo.utils.ModelMapper;

@RestController
@RequestMapping("/score")
public class ScoreController {
	@Autowired
    ScoreRepository scoreRepository;

	@Autowired
	private ScoreService scoreService;
	
	@CrossOrigin(origins="*")
	@GetMapping("/all")
	public List<ScoreResponse> classement(){
		List<ScoreResponse> list=scoreService.findAllScore();
		return list;
	}
	
	@CrossOrigin(origins="*")
	@GetMapping("/{pseudo}")
	public ScoreResponse getScore(@PathVariable String pseudo) {
		ScoreResponse scoreResponse;
		try {
		scoreResponse=scoreService.getScore(pseudo);
		}catch(Exception e) {
			Score score=new Score();
			score.setPseudo(pseudo);
			scoreRepository.save(score);
			scoreResponse=ModelMapper.mapScoreToScoreResponse(score);
		}
		scoreResponse=scoreService.getScore(pseudo);
		scoreResponse.setNbPartie(scoreResponse.getNbPartie()+scoreResponse.getAccepte()+scoreResponse.getRefuse());
		scoreResponse.setScore(scoreResponse.getScore()+scoreResponse.getAccepte());
		
		return scoreResponse;
	}
	
	@CrossOrigin(origins="*")
	@PostMapping("/maj")
	public void putScore(@Validated @RequestParam Map<String,String> scoreRequest) {
		Score score=new Score();
		score=scoreRepository.findByPseudo(scoreRequest.get("pseudo")).get();
		score.setScore(Integer.parseInt(scoreRequest.get("score")));
		score.setNbPartie(Integer.parseInt(scoreRequest.get("nb_partie")));
		score.setEnAttente(Integer.parseInt(scoreRequest.get("en_attente")));
		score.setAccepte(0);
		score.setRefuse(0);
		scoreRepository.save(score);
	}
}
