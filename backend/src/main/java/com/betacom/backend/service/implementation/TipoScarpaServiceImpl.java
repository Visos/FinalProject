package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.ITipoScarpaRepository;
import com.betacom.backend.request.TipoScarpaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.ITipoScarpaService;

@Service
public class TipoScarpaServiceImpl implements ITipoScarpaService {

	@Autowired
	IMessaggioService msgS;
	@Autowired
	ITipoScarpaRepository tipoScarpaR;
	
	
	
	@Override
	public void createOrUpdate(TipoScarpaReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoScarpaReq searchById(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoScarpaReq searchByDesc(String desc) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
