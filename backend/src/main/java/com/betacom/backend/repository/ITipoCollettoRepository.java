package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.TipoColletto;

public interface ITipoCollettoRepository extends JpaRepository<TipoColletto, Integer>{
	
	Optional<TipoColletto> findByDesc(String desc);

}
