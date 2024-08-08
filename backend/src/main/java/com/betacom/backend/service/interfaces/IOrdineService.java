package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.OrdineReq;

public interface IOrdineService {

    void create(OrdineReq req) throws AcademyException;
    
}
