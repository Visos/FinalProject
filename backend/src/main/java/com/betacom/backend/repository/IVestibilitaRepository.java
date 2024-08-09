package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Vestibilita;

public interface IVestibilitaRepository extends JpaRepository<Vestibilita, Integer>{
	
	Optional<Vestibilita> findByDesc(String desc);

}
