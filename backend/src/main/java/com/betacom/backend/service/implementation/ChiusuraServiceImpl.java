package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IChiusuraRepository;
import com.betacom.backend.request.ChiusuraReq;
import com.betacom.backend.service.interfaces.IChiusuraService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class ChiusuraServiceImpl implements IChiusuraService{
	
	@Autowired
	IChiusuraRepository chiuR;
	
	@Autowired
	IMessaggioService msgS;


	@Override
	public void createOrUpdate(ChiusuraReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChiusuraReq searchByDesc(String desc) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChiusuraReq searchById(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
