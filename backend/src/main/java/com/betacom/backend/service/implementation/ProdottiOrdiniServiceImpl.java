package com.betacom.backend.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.ProdottiOrdini;
import com.betacom.backend.repository.IProdottiOrdiniRepository;
import com.betacom.backend.request.ProdottiOrdiniReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IOrdineService;
import com.betacom.backend.service.interfaces.IProdottiOrdiniService;

@Service
public class ProdottiOrdiniServiceImpl implements IProdottiOrdiniService  {

    @Autowired
    IProdottiOrdiniRepository prodOrdR;

    @Autowired
    IOrdineService ordineS;

    @Autowired
    IMessaggioService msgS;
    
    @Override
    public void create(ProdottiOrdiniReq req) throws AcademyException {
        
        ProdottiOrdini prodOrd = null;

        if (req.getId() != null) {
            Optional<ProdottiOrdini> optional = prodOrdR.findById(req.getId());
            if (optional.isPresent()) {
                prodOrd = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("prodOrdini-ntexist"));
            }
        } else {
            prodOrd = new ProdottiOrdini();
        }

        prodOrd.setQty(req.getQty());
        prodOrd.setOrdine(ordineS.getOrdine(req.getIdOrdine()));
        prodOrd.setProdotto(null);
        
        
    }

    @Override
    public ProdottiOrdiniReq searchById(Integer id) throws AcademyException {
        Optional<ProdottiOrdini> optional = prodOrdR.findById(id);
        if (optional.isEmpty())
            throw new AcademyException(msgS.getMessaggio("prodOrdini-ntexist"));
        
        return new ProdottiOrdiniReq(
                optional.get().getId(),
                optional.get().getQty(),
                optional.get().getOrdine().getId(),
                optional.get().getProdotto().getId()
        );
    }

    @Override
    public void remove(Integer id) throws AcademyException {
        Optional<ProdottiOrdini> optional = prodOrdR.findById(id);
        if (optional.isPresent()) {
            prodOrdR.delete(optional.get());
        } else {
            throw new AcademyException(msgS.getMessaggio("prodOrdini-ntexist"));
        }
    }

}
