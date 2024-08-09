package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Colore;

public interface IColoreRepository extends JpaRepository<Colore, Integer>{

	Colore findByDesc(String desc);
}
