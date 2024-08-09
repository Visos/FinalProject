package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.LunghezzaManica;

@Repository
public interface ILunghezzaManicaRepository extends JpaRepository<LunghezzaManica, Integer> {

    LunghezzaManica findByDesc(String desc);
    
}
