package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Ordine;

@Repository
public interface IOrdineRepository extends JpaRepository<Ordine, Integer>  {

}
