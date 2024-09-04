package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ProdottiOrdiniReq;

public interface IProdottiOrdiniService {

    void createOrUpdate(ProdottiOrdiniReq req) throws AcademyException;
    ProdottiOrdiniReq searchById(Integer id) throws AcademyException;
    void remove(Integer id) throws AcademyException;
    void addProdToCarrello(ProdottiOrdiniReq req) throws AcademyException;
}
