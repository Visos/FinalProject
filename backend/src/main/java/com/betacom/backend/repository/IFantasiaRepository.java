package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Fantasia;

public interface IFantasiaRepository extends JpaRepository<Fantasia, Integer>{
	Optional< Fantasia> findByDesc(String desc);
}
