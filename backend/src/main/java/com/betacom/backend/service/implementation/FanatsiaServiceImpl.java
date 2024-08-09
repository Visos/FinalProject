package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IFantasiaRepository;
import com.betacom.backend.request.FantasiaReq;
import com.betacom.backend.service.interfaces.IFantasiaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

public class FanatsiaServiceImpl implements IFantasiaService{
	
	@Autowired
	IFantasiaRepository fanR;
	
	@Autowired
	IMessaggioService msgS;

	@Override
	public void createOrUpdate(FantasiaReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FantasiaReq searchByDesc(String desc) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FantasiaReq searchById(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
