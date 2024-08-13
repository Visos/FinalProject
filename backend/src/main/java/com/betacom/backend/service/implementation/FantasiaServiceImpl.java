package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Fantasia;
import com.betacom.backend.repository.IFantasiaRepository;
import com.betacom.backend.request.FantasiaReq;
import com.betacom.backend.service.interfaces.IFantasiaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class FantasiaServiceImpl implements IFantasiaService {

    @Autowired
    IFantasiaRepository fantasiaR;
    
    @Autowired
    IMessaggioService msgS;
    
    @Override
    public void createOrUpdate(FantasiaReq req) throws AcademyException {

        Fantasia fantasia = null;
        
        if (req.getId() != null) {
            Optional<Fantasia> optional = fantasiaR.findById(req.getId());
            if (optional.isPresent()) {
                fantasia = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("fantasia-ntexist"));
            }
        } else {
            fantasia = new Fantasia();
        }

        if (req.getDescrizione() != null) {
            List<Fantasia> lFantasia = fantasiaR.findAll();
            for (Fantasia fan : lFantasia) {
                if (req.getDescrizione().equalsIgnoreCase(fan.getDesc())) {
                    throw new AcademyException(msgS.getMessaggio("fantasia-exist"));
                }
            }
        } else {
            throw new AcademyException(msgS.getMessaggio("fantasia-desc-null"));
        }

        fantasia.setDesc(req.getDescrizione());

        try {
            fantasiaR.save(fantasia);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("lunghezza-generic") + e.getMessage());
        }

    }

    @Override
    public FantasiaReq searchByDesc(String desc) throws AcademyException {
        Optional<Fantasia> fan = fantasiaR.findByDesc(desc);
        if (fan.isEmpty()) {
            throw new AcademyException("fantasia-ntexist");
        }
        
        return new FantasiaReq(fan.get().getId(), desc);
    }

    @Override
    public FantasiaReq searchById(Integer id) throws AcademyException {
        Optional<Fantasia> fan = fantasiaR.findById(id);
        if (fan.isEmpty()) {
            throw new AcademyException("fantasia-ntexist");
        }
        
        return new FantasiaReq(id, fan.get().getDesc());
    }

}
