package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Utente;

@Repository
public interface IUtenteRepository extends JpaRepository<Utente, Integer>  {

}
