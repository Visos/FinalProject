package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.IProdottoRepository;
import com.betacom.backend.service.interfaces.IProdottoService;
import com.betacom.backend.service.interfaces.ProdottoReq;

@Service
public class ProdottoServiceImpl implements IProdottoService {
	
	@Autowired
	IProdottoRepository prodottoR; 
	
	@Override
	public void create(ProdottoReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

}
