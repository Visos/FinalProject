package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IVestitoRepository;
import com.betacom.backend.request.VestitoReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IVestitoService;

@Service
public class VestitoServiceImpl implements IVestitoService {
	
	@Autowired
	IMessaggioService msgS;
	
	@Autowired
	IVestitoRepository vestitoR;

	@Override
	public void create(VestitoReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

}
