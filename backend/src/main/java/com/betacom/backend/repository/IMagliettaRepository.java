package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Maglietta;

@Repository
public interface IMagliettaRepository extends JpaRepository<Maglietta, Integer>{
	
	

}
