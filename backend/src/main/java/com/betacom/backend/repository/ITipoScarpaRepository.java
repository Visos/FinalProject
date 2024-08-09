package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.TipoScarpa;

public interface ITipoScarpaRepository extends JpaRepository<TipoScarpa, Integer> {

	Optional<TipoScarpa> findByDesc(String desc);

}
