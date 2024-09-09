package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.UtenteDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Utente;
import com.betacom.backend.request.UtenteReq;

public interface IUtenteService {

    void createOrUpdate(UtenteReq req) throws AcademyException;
    UtenteReq searchById(Integer id) throws AcademyException;
    UtenteReq searchByMail(String mail) throws AcademyException;
    List<UtenteDTO> listAll();
    Utente getUtente(Integer id) throws AcademyException;
    UtenteDTO signIn(String mail, String password) throws AcademyException;
}
