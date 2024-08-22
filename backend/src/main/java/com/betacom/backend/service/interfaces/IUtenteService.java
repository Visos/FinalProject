package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.UtenteDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Utente;
import com.betacom.backend.request.UtenteReq;

public interface IUtenteService {

    void createOrUpdate(UtenteReq req) throws AcademyException;
    UtenteDTO searchById(Integer id) throws AcademyException;
    UtenteDTO searchByMail(String mail) throws AcademyException;
    List<UtenteDTO> listAll();
    Utente getUtente(Integer id) throws AcademyException;
}
