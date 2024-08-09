package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Lunghezza;
import com.betacom.backend.repository.ILunghezzaRepository;
import com.betacom.backend.request.LunghezzaReq;
import com.betacom.backend.service.interfaces.ILunghezzaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class LunghezzaServiceImpl implements ILunghezzaService  {

    @Autowired
    ILunghezzaRepository lunghezzaR;
    
    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(LunghezzaReq req) throws AcademyException {
        
        Lunghezza lunghezza = null;
        
        if (req.getId()!= null) {
            Optional<Lunghezza> optional = lunghezzaR.findById(req.getId());
            if (optional.isPresent()) {
                lunghezza = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("lunghezza-ntexist"));
            }
        } else {
            lunghezza = new Lunghezza();
        }

         if (req.getDescrizione()!= null) {
            List<Lunghezza> lL = lunghezzaR.findAll();
            for (Lunghezza l:lL) {
                if(req.getDescrizione().equalsIgnoreCase(l.getDesc()))
                    throw new AcademyException(msgS.getMessaggio("lunghezza-exist"));
            }
        } else 
            throw new AcademyException(msgS.getMessaggio("lunghezza-desc-null"));
            
        lunghezza.setDesc(req.getDescrizione());

        try {
            lunghezzaR.save(lunghezza);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("lunghezza-generic") + e.getMessage());
        }

    }

    @Override
    public LunghezzaReq searchByDesc(String desc) throws AcademyException {
        
        Optional<Lunghezza> optional = lunghezzaR.findByDesc(desc);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("lunghezza-no-desc"));
        
        return new LunghezzaReq(
            optional.get().getId(),
            optional.get().getDesc()
        );
    }

    @Override
    public LunghezzaReq searchById(Integer id) throws AcademyException {

        Optional<Lunghezza> optional = lunghezzaR.findById(id);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("lunghezza-ntexist"));
        
        return new LunghezzaReq(
            optional.get().getId(),
            optional.get().getDesc()
        );
    }


}
