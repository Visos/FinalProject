package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Lunghezza;

@Repository
public interface ILunghezzaRepository extends JpaRepository<Lunghezza, Integer>{

    Optional<Lunghezza> findByDesc(String desc);
    
}
