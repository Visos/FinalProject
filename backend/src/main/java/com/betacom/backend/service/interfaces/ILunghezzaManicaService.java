package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.LunghezzaManicaReq;

public interface ILunghezzaManicaService {

    void createOrUpdate(LunghezzaManicaReq req) throws AcademyException;
    LunghezzaManicaReq searchByDesc(String desc) throws AcademyException;
    LunghezzaManicaReq searchById(Integer id) throws AcademyException;
    List<LunghezzaManicaReq> listAll();

}
