package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.ILunghezzaRepository;
import com.betacom.backend.request.LunghezzaReq;
import com.betacom.backend.service.interfaces.ILunghezzaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class LunghezzaServiceImpl implements ILunghezzaService  {

    @Autowired
    ILunghezzaRepository lunghezzaR;
    
    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(LunghezzaReq req) throws AcademyException {
        
    }

    @Override
    public LunghezzaReq searchByDesc(String desc) throws AcademyException {
        
        return null;
    }

    @Override
    public LunghezzaReq searchById(Integer id) throws AcademyException {
        
        return null;
    }


}
