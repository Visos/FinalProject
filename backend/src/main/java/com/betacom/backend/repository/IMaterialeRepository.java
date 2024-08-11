package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Materiale;

@Repository
public interface IMaterialeRepository extends JpaRepository<Materiale, Integer>{

    Optional<Materiale> findByDesc(String desc);
}
