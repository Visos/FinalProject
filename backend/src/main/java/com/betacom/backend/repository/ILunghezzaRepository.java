package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Lunghezza;

@Repository
public interface ILunghezzaRepository extends JpaRepository<Lunghezza, Integer>{

    Lunghezza findByDesc(String desc);
    
}
