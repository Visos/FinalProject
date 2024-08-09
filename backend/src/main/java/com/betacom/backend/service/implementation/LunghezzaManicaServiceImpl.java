package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.ILunghezzaManicaRepository;
import com.betacom.backend.request.LunghezzaManicaReq;
import com.betacom.backend.service.interfaces.ILunghezzaManicaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class LunghezzaManicaServiceImpl implements ILunghezzaManicaService{

    @Autowired
    ILunghezzaManicaRepository lManicaR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(LunghezzaManicaReq req) throws AcademyException {
        
    }

    @Override
    public LunghezzaManicaReq searchByDesc(String desc) throws AcademyException {
        
        return null;
    }

    @Override
    public LunghezzaManicaReq searchById(Integer id) throws AcademyException {

        return null;
    }
    
}
