package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Colore;
import com.betacom.backend.repository.IColoreRepository;
import com.betacom.backend.request.ColoreReq;
import com.betacom.backend.service.interfaces.IColoreService;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.dto.ColoreDTO;

@Service
public class ColoreServiceImpl implements IColoreService{

	@Autowired
	IColoreRepository colR;
	
	@Autowired
	IMessaggioService msgS;
	
	@Override
	public void createOrUpdate(ColoreReq req) throws AcademyException {

        
        Colore colore = null;
        
        if (req.getId()!= null) {
            Optional<Colore> optional = colR.findById(req.getId());
            if (optional.isPresent()) {
            	colore = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("colore-ntexist"));
            }
        } else {
        	colore = new Colore();
        } 

        
        if(req.getDescrizione() != null) {
            List<Colore> lCol = colR.findAll();
            for (Colore col:lCol) {
                if(req.getDescrizione().equalsIgnoreCase(col.getDesc()))
                    throw new AcademyException(msgS.getMessaggio("colore-exist"));
            }
        }else {
        	throw new AcademyException(msgS.getMessaggio("colore-desc-null"));
        }

        colore.setDesc(req.getDescrizione());


        try {
            colR.save(colore);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("colore-generic") + e.getMessage());
        }

	}

	@Override
	public ColoreDTO searchByDesc(String desc) throws AcademyException {
		Optional<Colore> col = colR.findByDesc(desc);
		if(col.isEmpty())
			throw new AcademyException("colore-ntexist");
		
		return new ColoreDTO(col.get().getId(), desc);
	}

	@Override
	public ColoreDTO searchById(Integer id) throws AcademyException {
		Optional<Colore> col = colR.findById(id);
		if(col.isEmpty())
			throw new AcademyException("colore-ntexist");
		
		return new ColoreDTO(id, col.get().getDesc());
	}
	
	
	  @Override
	    public List<ColoreDTO> listAll() {
		  return null;
	      //  return trasformInDTO(colR.findAll());
	    }

//	    private List<ColoreDTO> trasformInDTO(List<Colore> resp) {
//	        return resp.stream()
//	                .map(k -> new ColoreDTO(
//	                        k.getId(),
//	                        k.getDesc(),
//	                        k.getProdotti()
//	                ))
//	                .collect(Collectors.toList());
//	    }

}
