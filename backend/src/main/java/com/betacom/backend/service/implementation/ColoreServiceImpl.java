package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IColoreRepository;
import com.betacom.backend.request.ColoreReq;
import com.betacom.backend.service.interfaces.IColoreService;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class ColoreServiceImpl implements IColoreService{

	@Autowired
	IColoreRepository colR;
	
	@Autowired
	IMessaggioService msgS;
	
	@Override
	public void createOrUpdate(ColoreReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ColoreReq searchByDesc(String desc) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColoreReq searchById(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
