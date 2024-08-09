package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Fantasia;

public interface IFantasiaRepository extends JpaRepository<Fantasia, Integer>{
	Fantasia findByDesc(String desc);
}
