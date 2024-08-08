package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ProdottiOrdiniReq;

public interface IProdottiOrdiniService {

    void create(ProdottiOrdiniReq req) throws AcademyException;

}
