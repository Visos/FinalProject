package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.ProdottiOrdini;

@Repository
public interface IProdottiOrdiniRepository extends JpaRepository<ProdottiOrdini, Integer>  {

}
