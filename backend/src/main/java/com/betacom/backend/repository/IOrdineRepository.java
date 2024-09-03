package com.betacom.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.util.Stato;

@Repository
public interface IOrdineRepository extends JpaRepository<Ordine, Integer>  {

    @Query("SELECT o FROM Ordine o " + 
        "WHERE (:id IS NULL OR o.utente.id = :id) " +
        "AND (:stato IS NULL OR o.stato = :stato)") 
    List<Ordine> findByParam(
        @Param("id") Integer id,
        @Param("stato") Stato stato);
    
}
