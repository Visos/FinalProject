package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Marca;
import com.betacom.backend.repository.IMarcaRepository;
import com.betacom.backend.request.MarcaReq;
import com.betacom.backend.service.interfaces.IMarcaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class MarcaServiceImpl implements IMarcaService  {

    @Autowired
    IMarcaRepository marcaR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(MarcaReq req) throws AcademyException {

        Marca marca = null;
        
        if (req.getId()!= null) {
            Optional<Marca> optional = marcaR.findById(req.getId());
            if (optional.isPresent()) {
                marca = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("marca-ntexist"));
            }
        } else {
            marca = new Marca();
        }

         if (req.getDescrizione()!= null) {
            List<Marca> lM = marcaR.findAll();
            for (Marca m:lM) {
                if(req.getDescrizione().equalsIgnoreCase(m.getDesc()))
                    throw new AcademyException(msgS.getMessaggio("marca-exist"));
            }
        } else 
            throw new AcademyException(msgS.getMessaggio("marca-desc-null"));
            
        marca.setDesc(req.getDescrizione());

        try {
            marcaR.save(marca);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("marca-generic") + e.getMessage());
        }
    }

    @Override
    public MarcaReq searchByDesc(String desc) throws AcademyException {
     
        Optional<Marca> optional = marcaR.findByDesc(desc);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("marca-no-desc"));
        
        return new MarcaReq(
            optional.get().getId(),
            optional.get().getDesc()
        );
    }

    @Override
    public MarcaReq searchById(Integer id) throws AcademyException {
        
        Optional<Marca> optional = marcaR.findById(id);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("marca-ntexist"));
        
        return new MarcaReq(
            optional.get().getId(),
            optional.get().getDesc()
        );
    }

    
}
