package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Vestito;

@Repository
public interface IVestitoRepository extends JpaRepository<Vestito, Integer>{

}
