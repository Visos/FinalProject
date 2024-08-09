package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Taglia;

public interface ITagliaRepository extends JpaRepository<Taglia, Integer>{
	
	Optional<Taglia> findByDesc(String desc);

}
