package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.MarcaReq;

public interface IMarcaService {

    void createOrUpdate(MarcaReq req) throws AcademyException;
    MarcaReq searchByDesc(String desc) throws AcademyException;
    MarcaReq searchById(Integer id) throws AcademyException;
    
}
