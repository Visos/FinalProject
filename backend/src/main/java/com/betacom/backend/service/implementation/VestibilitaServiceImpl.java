package com.betacom.backend.service.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
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
		// TODO Auto-generated method stub
		
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
