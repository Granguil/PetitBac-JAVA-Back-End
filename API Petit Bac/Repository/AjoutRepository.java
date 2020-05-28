package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Ajout;

public interface AjoutRepository extends JpaRepository<Ajout,Integer>{
	Optional<Ajout> findByMotAndCategorieBean_categorieAndPseudo(String mot,String categorie,String pseudo);
}
