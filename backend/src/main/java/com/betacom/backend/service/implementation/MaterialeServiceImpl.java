package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IMaterialeRepository;
import com.betacom.backend.request.MaterialeReq;
import com.betacom.backend.service.interfaces.IMaterialeService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class MaterialeServiceImpl implements IMaterialeService{

    @Autowired
    IMaterialeRepository materialeR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(MaterialeReq req) throws AcademyException {
        
    }

    @Override
    public MaterialeReq searchByDesc(String desc) throws AcademyException {
        
        return null;
    }

    @Override
    public MaterialeReq searchById(Integer id) throws AcademyException {
        
        return null;
    }
}
