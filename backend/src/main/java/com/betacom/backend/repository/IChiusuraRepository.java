package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Chiusura;

public interface IChiusuraRepository extends JpaRepository<Chiusura, Integer>{

	Chiusura findByDesc(String desc);
}
