package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.OrdineDTO;
import com.betacom.backend.dto.ProdottiOrdiniDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.pojo.ProdottiOrdini;
import com.betacom.backend.request.OrdineReq;
import com.betacom.backend.util.Stato;

public interface IOrdineService {

    void createOrUpdate(OrdineReq req) throws AcademyException;
    OrdineReq searchById(Integer id) throws AcademyException;
    List<OrdineDTO> list(Integer id, Stato stato);
    Ordine getOrdine(Integer id) throws AcademyException;
    void remove(Integer id) throws AcademyException;
    List<ProdottiOrdini> listAllByOrdine(Integer id) throws AcademyException;
    List<ProdottiOrdiniDTO> transformProdottiOrdiniInDTO(List<ProdottiOrdini> resp);
}
