package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.OrdineReq;

public interface IOrdineService {

    void createOrUpdate(OrdineReq req) throws AcademyException;
    
}
