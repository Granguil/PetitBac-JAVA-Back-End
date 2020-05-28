package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.MotRepository;
import com.example.demo.Response.MotResponse;
import com.example.demo.entities.Mot;
import com.example.demo.utils.ModelMapper;

@Service
public class MotService {
	@Autowired 
	private MotRepository MR;
	
	public List<MotResponse> findAllMot() {

		List<Mot> mots = MR.findAll();

		List<MotResponse> responses = mots.stream().map(mot -> {
			return ModelMapper.mapMotToMotResponse(mot);
		}).collect(Collectors.toList());

		return responses;
	}

	public MotResponse verif(String mot, String categorie) {
		MotResponse motResponse=new MotResponse();
		motResponse=ModelMapper.mapMotToMotResponse(MR.findByMotAndCategorieBean_categorie(mot, categorie).get());
		return motResponse;
	}
	public MotResponse getMot(int id) {
		return ModelMapper.mapMotToMotResponse(MR.findById(id).get());
	}
}
