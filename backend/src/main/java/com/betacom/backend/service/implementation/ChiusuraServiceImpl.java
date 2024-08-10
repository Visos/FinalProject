package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Chiusura;
import com.betacom.backend.repository.IChiusuraRepository;
import com.betacom.backend.request.ChiusuraReq;
import com.betacom.backend.service.interfaces.IChiusuraService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class ChiusuraServiceImpl implements IChiusuraService {

    @Autowired
    IChiusuraRepository chiusuraR;
    
    @Autowired
    IMessaggioService msgS;
    
    @Override
    public void createOrUpdate(ChiusuraReq req) throws AcademyException {

        Chiusura chiusura = null;
        
        if (req.getId() != null) {
            Optional<Chiusura> optional = chiusuraR.findById(req.getId());
            if (optional.isPresent()) {
                chiusura = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("chiusura-ntexist"));
            }
        } else {
            chiusura = new Chiusura();
        }

        if (req.getDescrizione() != null) {
            List<Chiusura> lChiusura = chiusuraR.findAll();
            for (Chiusura chi : lChiusura) {
                if (req.getDescrizione().equalsIgnoreCase(chi.getDesc())) {
                    throw new AcademyException(msgS.getMessaggio("chiusura-exist"));
                }
            }
        } else {
            throw new AcademyException(msgS.getMessaggio("chiusura-desc-null"));
        }

        chiusura.setDesc(req.getDescrizione());

        try {
            chiusuraR.save(chiusura);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("chiusura-generic") + e.getMessage());
        }

    }

    @Override
    public ChiusuraReq searchByDesc(String desc) throws AcademyException {
        Optional<Chiusura> chi = chiusuraR.findByDesc(desc);
        if (chi.isEmpty()) {
            throw new AcademyException("chiusura-ntexist");
        }
        
        return new ChiusuraReq(chi.get().getId(), desc);
    }

    @Override
    public ChiusuraReq searchById(Integer id) throws AcademyException {
        Optional<Chiusura> chi = chiusuraR.findById(id);
        if (chi.isEmpty()) {
            throw new AcademyException("chiusura-ntexist");
        }
        
        return new ChiusuraReq(id, chi.get().getDesc());
    }

}
