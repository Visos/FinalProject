package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IOrdineRepository;
import com.betacom.backend.request.OrdineReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IOrdineService;

@Service
public class OrdineServiceImpl implements IOrdineService  {

    @Autowired
    IOrdineRepository ordineR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void create(OrdineReq req) throws AcademyException {
        
    }

}
