package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IUtenteRepository;
import com.betacom.backend.request.UtenteReq;
import com.betacom.backend.service.interfaces.IUtenteService;

@Service
public class UtenteServiceImpl implements IUtenteService {

    @Autowired
    IUtenteRepository utenteR;

    @Override
    public void create(UtenteReq req) throws AcademyException {
    }

}
