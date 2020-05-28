package com.example.demo.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.AjoutRepository;
import com.example.demo.Response.AjoutResponse;
import com.example.demo.entities.Ajout;
import com.example.demo.utils.ModelMapper;

@Service
public class AjoutService {
	@Autowired
	private AjoutRepository AR;
	

	public List<AjoutResponse> findAllAjout() {

		List<Ajout> ajout = AR.findAll();

		List<AjoutResponse> responses = ajout.stream().map(a -> {
			return ModelMapper.mapAjoutToAjoutResponse(a);
		}).collect(Collectors.toList());

		return responses;
	}

	public AjoutResponse getAjout(String mot,String categorie,String pseudo) {
		return ModelMapper.mapAjoutToAjoutResponse(AR.findByMotAndCategorieBean_categorieAndPseudo(mot,categorie,pseudo).get());
	}

}
