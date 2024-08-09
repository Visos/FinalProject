package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.ICamiciaRepository;
import com.betacom.backend.request.CamiciaReq;
import com.betacom.backend.service.interfaces.ICamiciaService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class CamiciaServiceImpl implements ICamiciaService{

	@Autowired
	ICamiciaRepository camiciaR;
	
	@Autowired
	IMessaggioService msgS;
	
	@Override
	public void create(CamiciaReq req) throws AcademyException{
		
	}

}
