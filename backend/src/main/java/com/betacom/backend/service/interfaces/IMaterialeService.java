package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.MaterialeReq;

public interface IMaterialeService {

    void createOrUpdate(MaterialeReq req) throws AcademyException;
    MaterialeReq searchByDesc(String desc) throws AcademyException;
    MaterialeReq searchById(Integer id) throws AcademyException;
    List<MaterialeReq> listAll();
}
