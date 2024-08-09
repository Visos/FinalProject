package com.betacom.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betacom.backend.pojo.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Integer>  {

    Marca findByDesc(String desc);

}
