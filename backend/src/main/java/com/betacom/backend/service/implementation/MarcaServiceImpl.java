package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IMarcaRepository;
import com.betacom.backend.request.MarcaReq;
import com.betacom.backend.service.interfaces.IMarcaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class MarcaServiceImpl implements IMarcaService  {

    @Autowired
    IMarcaRepository marcaR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(MarcaReq req) throws AcademyException {
        
    }

    @Override
    public MarcaReq searchByDesc(String desc) throws AcademyException {
     
        return null;
    }

    @Override
    public MarcaReq searchById(Integer id) throws AcademyException {
        
        return null;
    }

    
}
