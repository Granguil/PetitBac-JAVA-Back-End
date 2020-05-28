package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Mot;

public interface MotRepository extends JpaRepository<Mot, Integer> {
	Optional<Mot> findByMotAndCategorieBean_categorie(String Mot, String Categorie);
}
