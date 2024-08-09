package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IProdottiOrdiniRepository;
import com.betacom.backend.request.ProdottiOrdiniReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IProdottiOrdiniService;

@Service
public class ProdottiOrdiniServiceImpl implements IProdottiOrdiniService  {

    @Autowired
    IProdottiOrdiniRepository prodOrdR;

    @Autowired
    IMessaggioService msgS;
    
    @Override
    public void create(ProdottiOrdiniReq req) throws AcademyException {
        
    }

}
