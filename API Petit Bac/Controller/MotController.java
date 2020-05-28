package com.example.demo.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Repository.MotRepository;
import com.example.demo.Request.MotRequest;
import com.example.demo.Response.APIResponse;
import com.example.demo.Response.MotResponse;
import com.example.demo.Service.MotService;
import com.example.demo.entities.Mot;

@RestController
@RequestMapping("/Mot")
public class MotController {
@Autowired
MotRepository motRepository;

@Autowired
private MotService motService;

@CrossOrigin(origins="*")
@GetMapping("/all")
public List<MotResponse> getMots(){
	List<MotResponse> listeMot=new ArrayList<MotResponse>();
	listeMot=motService.findAllMot();
	return listeMot;
}


@CrossOrigin(origins="*")
@PostMapping("/add")
public ResponseEntity<?> add(@Validated @RequestBody MotRequest motRequest){
	Mot mot=new Mot();
	mot.setCategorieBean(motRequest.getCategorieBean());
	mot.setMot(motRequest.getMot());
	Mot result=motRepository.save(mot);
	Map<String, String> urlParams = new HashMap<>();
	urlParams.put("mot", result.getMot());
	urlParams.put("categorie", result.getCategorieBean().getCategorie());
	URI location = ServletUriComponentsBuilder
            .fromCurrentContextPath().path("/Verif/mot={mot}&categorie={categorie}")
            .buildAndExpand(urlParams).toUri();

    return ResponseEntity.created(location).body(new APIResponse(true, "Mots registered successfully."));
	
}

@CrossOrigin(origins="*")
@GetMapping("/verif/{mot}/{categorie}")
public boolean verifMot(@PathVariable String mot,@PathVariable String categorie) {
	Boolean bool=false;
	MotResponse motResponse=new MotResponse();
	try {
		motResponse=motService.verif(mot, categorie);
		bool=true;
	}catch(Exception e) {
		
	}
	return bool;
}

}
