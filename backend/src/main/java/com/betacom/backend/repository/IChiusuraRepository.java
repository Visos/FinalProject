package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Chiusura;

public interface IChiusuraRepository extends JpaRepository<Chiusura, Integer>{

	Optional<Chiusura> findByDesc(String desc);
}
