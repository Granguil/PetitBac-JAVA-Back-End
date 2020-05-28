package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Score;

public interface ScoreRepository  extends JpaRepository<Score, Integer> {
	Optional<Score> findById(int id);
	Optional<Score> findByPseudo(String pseudo);
}


