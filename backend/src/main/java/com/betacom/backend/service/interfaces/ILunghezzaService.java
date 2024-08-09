package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.LunghezzaReq;

public interface ILunghezzaService {
    
    void createOrUpdate(LunghezzaReq req) throws AcademyException;
    LunghezzaReq searchByDesc(String desc) throws AcademyException;
    LunghezzaReq searchById(Integer id) throws AcademyException;

}
