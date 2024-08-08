package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.repository.IPantaloneRepository;
import com.betacom.backend.request.PantaloneReq;
import com.betacom.backend.service.interfaces.IPantaloneService;

@Service
public class PantaloniServiceImpl implements IPantaloneService{

	@Autowired
	IPantaloneRepository pantR;

	@Override
	public void create(PantaloneReq req) {
		// TODO Auto-generated method stub
		
	}

}
