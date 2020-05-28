package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ScoreRepository;
import com.example.demo.Response.ScoreResponse;
import com.example.demo.entities.Score;
import com.example.demo.utils.ModelMapper;

@Service
public class ScoreService {
	@Autowired
	private ScoreRepository SR;
	
	public List<ScoreResponse> findAllScore() {

		List<Score> scores = SR.findAll(Sort.by(Sort.Direction.DESC,"score"));

		List<ScoreResponse> responses = scores.stream().map(score -> {
			return ModelMapper.mapScoreToScoreResponse(score);
		}).collect(Collectors.toList());

		return responses;
	}

	public ScoreResponse getScore(String pseudo) {
		return ModelMapper.mapScoreToScoreResponse(SR.findByPseudo(pseudo).get());
	}
}
