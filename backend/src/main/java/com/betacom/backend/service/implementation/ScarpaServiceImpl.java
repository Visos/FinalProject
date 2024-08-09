package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IScarpaRepository;
import com.betacom.backend.request.ScarpaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IScarpaService;


@Service
public class ScarpaServiceImpl implements IScarpaService {
	
	@Autowired
	IMessaggioService msgS;
	
	@Autowired
	IScarpaRepository scarpaR;

	@Override
	public void create(ScarpaReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

}
