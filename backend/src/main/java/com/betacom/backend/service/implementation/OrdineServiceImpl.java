package com.betacom.backend.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.repository.IOrdineRepository;
import com.betacom.backend.request.OrdineReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IOrdineService;

@Service
public class OrdineServiceImpl implements IOrdineService  {

    @Autowired
    IOrdineRepository ordineR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(OrdineReq req) throws AcademyException {
        
        Ordine ordine = null;

        if (req.getId() != null) {
            Optional<Ordine> optional = ordineR.findById(req.getId());
            if (optional.isPresent()) {
                ordine = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("ordine-ntexist"));
            }
        } else {
            ordine = new Ordine();
        }


        try {
            ordineR.save(ordine);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("ordine-generic") + e.getMessage());
        }
    }

}
