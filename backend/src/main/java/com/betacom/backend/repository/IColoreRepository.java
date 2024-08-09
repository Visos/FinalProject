package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Colore;

public interface IColoreRepository extends JpaRepository<Colore, Integer>{

	Optional<Colore> findByDesc(String desc);
}
