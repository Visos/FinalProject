package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.LunghezzaManica;
import com.betacom.backend.repository.ILunghezzaManicaRepository;
import com.betacom.backend.request.LunghezzaManicaReq;
import com.betacom.backend.service.interfaces.ILunghezzaManicaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class LunghezzaManicaServiceImpl implements ILunghezzaManicaService{

    @Autowired
    ILunghezzaManicaRepository lManicaR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(LunghezzaManicaReq req) throws AcademyException {
        
        LunghezzaManica lManica = null;
        
        if (req.getId()!= null) {
            Optional<LunghezzaManica> optional = lManicaR.findById(req.getId());
            if (optional.isPresent()) {
                lManica = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("lunghezzaManica-ntexist"));
            }
        } else {
            lManica = new LunghezzaManica();
        }

        if (req.getDescrizione()!= null) {
            List<LunghezzaManica> lLM = lManicaR.findAll();
            for (LunghezzaManica l:lLM) {
                if(req.getDescrizione().equalsIgnoreCase(l.getDesc()))
                    throw new AcademyException(msgS.getMessaggio("lunghezzaManica-exist"));
            }
        } else 
            throw new AcademyException(msgS.getMessaggio("lunghezzaManica-desc-null"));
            
        lManica.setDesc(req.getDescrizione());

        try {
            lManicaR.save(lManica); 
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("lunghezzaManica-generic") + e.getMessage());
        }

    }

    @Override
    public LunghezzaManicaReq searchByDesc(String desc) throws AcademyException {
        
        Optional<LunghezzaManica> optional = lManicaR.findByDesc(desc);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("lunghezzaManica-ntexist"));
        
        return new LunghezzaManicaReq(
            optional.get().getId(),
            optional.get().getDesc());
    }

    @Override
    public LunghezzaManicaReq searchById(Integer id) throws AcademyException {

        Optional<LunghezzaManica> optional = lManicaR.findById(id);
        if (optional.isEmpty()) 
            throw new AcademyException(msgS.getMessaggio("lunghezzaManica-ntexist"));
        
        return new LunghezzaManicaReq(
            optional.get().getId(),
            optional.get().getDesc());
    }

    @Override
    public List<LunghezzaManicaReq> listAll() {
        return trasformInReq(lManicaR.findAll());
    }

    private List<LunghezzaManicaReq> trasformInReq(List<LunghezzaManica> resp){
		return resp.stream()
				.map(a -> new LunghezzaManicaReq(
						a.getId(),
                        a.getDesc()
						)
					)
				.collect(Collectors.toList());
	}

}
