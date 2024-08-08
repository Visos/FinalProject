package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.UtenteReq;

public interface IUtenteService {

    void create(UtenteReq req) throws AcademyException;

}
