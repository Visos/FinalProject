package com.betacom.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Utente;

@Repository
public interface IUtenteRepository extends JpaRepository<Utente, Integer>  {

    Optional<Utente> findByMail(String mail);
    Optional<Utente> findByMailAndPassword(String mail, String password);
}
