package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Prodotto;

@Repository
public interface IProdottoRepository extends JpaRepository<Prodotto, Integer> {

}
