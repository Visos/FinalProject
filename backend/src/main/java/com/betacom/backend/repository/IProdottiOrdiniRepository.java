package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.pojo.ProdottiOrdini;
import com.betacom.backend.pojo.Prodotto;

@Repository
public interface IProdottiOrdiniRepository extends JpaRepository<ProdottiOrdini, Integer>  {
	Optional<ProdottiOrdini> findByOrdineAndProdotto(Ordine ordine, Prodotto prodotto);

}
