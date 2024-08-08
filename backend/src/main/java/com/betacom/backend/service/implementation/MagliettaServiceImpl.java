package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.service.interfaces.IMagliettaService;
import com.betacom.backend.repository.IMagliettaRepository;
import com.betacom.backend.request.MagliettaReq;

@Service
public class MagliettaServiceImpl implements IMagliettaService{

	@Autowired
	IMagliettaRepository magliaR;
	
	@Override
	public void create(MagliettaReq req) {
		// TODO Auto-generated method stub
		
	}

}
