package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Camicia;

@Repository
public interface ICamiciaRepository extends JpaRepository<Camicia, Integer>{

}
