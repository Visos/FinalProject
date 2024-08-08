package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Messaggi;

@Repository
public interface IMessaggioRepository extends JpaRepository<Messaggi, String>{

}
