package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Materiale;
import com.betacom.backend.repository.IMaterialeRepository;
import com.betacom.backend.request.MaterialeReq;
import com.betacom.backend.service.interfaces.IMaterialeService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class MaterialeServiceImpl implements IMaterialeService{

    @Autowired
    IMaterialeRepository materialeR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(MaterialeReq req) throws AcademyException {
        
         Materiale materiale = null;
        
        if (req.getId()!= null) {
            Optional<Materiale> optional = materialeR.findById(req.getId());
            if (optional.isPresent()) {
                materiale = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("materiale-ntexist"));
            }
        } else {
            materiale = new Materiale();
        }

         if (req.getDescrizione()!= null) {
            List<Materiale> lM = materialeR.findAll();
            for (Materiale m:lM) {
                if(req.getDescrizione().equalsIgnoreCase(m.getDesc()))
                    throw new AcademyException(msgS.getMessaggio("materiale-exist"));
            }
        } else 
            throw new AcademyException(msgS.getMessaggio("materiale-desc-null"));
            
        materiale.setDesc(req.getDescrizione());

        try {
            materialeR.save(materiale);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("materiale-generic") + e.getMessage());
        }
    }

    @Override
    public MaterialeReq searchByDesc(String desc) throws AcademyException {
        Optional<Materiale> optional = materialeR.findByDesc(desc);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("materiale-no-desc"));
        
        return new MaterialeReq(
            optional.get().getId(),
            optional.get().getDesc()
        );
    }

    @Override
    public MaterialeReq searchById(Integer id) throws AcademyException {
        Optional<Materiale> optional = materialeR.findById(id);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("materiale-ntexist"));
        
        return new MaterialeReq(
            optional.get().getId(),
            optional.get().getDesc()
        );
    }
}
