package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.betacom.backend.pojo.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {

}
