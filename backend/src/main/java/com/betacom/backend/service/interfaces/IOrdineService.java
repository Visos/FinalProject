package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.OrdineDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.request.OrdineReq;

public interface IOrdineService {

    void createOrUpdate(OrdineReq req) throws AcademyException;
    OrdineReq searchById(Integer id) throws AcademyException;
    List<OrdineDTO> listAll();
    Ordine getOrdine(Integer id) throws AcademyException;
    void remove(Integer id) throws AcademyException;
}
