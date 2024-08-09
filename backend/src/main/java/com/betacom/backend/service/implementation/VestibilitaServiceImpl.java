package com.betacom.backend.service.implementation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Vestibilita;
import com.betacom.backend.repository.IVestibilitaRepository;
import com.betacom.backend.request.VestibilitaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IVestibilitaService;

@Service
public class VestibilitaServiceImpl implements IVestibilitaService{
	
	@Autowired
	IMessaggioService msgS;

	@Autowired
	IVestibilitaRepository vestibilitaR;
	
	@Override
	public void createOrUpdate(VestibilitaReq req) throws AcademyException {
		Vestibilita vestibilita = null;
		
		if(req.getId()!=null) {
			Optional<Vestibilita> opt = vestibilitaR.findById(req.getId());
			if(opt.isPresent())
				vestibilita = opt.get();
			else 
				throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));
		} else
			vestibilita = new Vestibilita();
		
		vestibilita.setDesc(req.getDescrizione());
		
		try {
			vestibilitaR.save(vestibilita);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("vestibilita-generic" + e.getMessage()));
		}
		
	}

	@Override
	public VestibilitaReq searchById(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VestibilitaReq searchByDesc(String desc) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
