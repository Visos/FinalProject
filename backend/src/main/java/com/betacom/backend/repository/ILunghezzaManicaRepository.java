package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.LunghezzaManica;

@Repository
public interface ILunghezzaManicaRepository extends JpaRepository<LunghezzaManica, Integer> {

    Optional<LunghezzaManica> findByDesc(String desc);
    
}
