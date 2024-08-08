package com.betacom.backend.service.implementation;

import com.betacom.backend.service.interfaces.IPantaloneService;
<<<<<<< Updated upstream
import com.betacom.backend.service.interfaces.PantaloneReq;

public class PantaloniServiceImpl implements IPantaloneService{

=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.repository.IPantaloneRepository;
import com.betacom.backend.request.PantaloneReq;

@Service
public class PantaloniServiceImpl implements IPantaloneService{

	@Autowired
	IPantaloneRepository pantR;

>>>>>>> Stashed changes
	@Override
	public void create(PantaloneReq req) {
		// TODO Auto-generated method stub
		
	}
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes

}
