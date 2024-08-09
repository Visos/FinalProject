package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.ITipoCollettoRepository;
import com.betacom.backend.request.TipoCollettoReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.ITipoCollettoService;

@Service
public class TipoCollettoServiceImpl implements ITipoCollettoService {
	@Autowired
	IMessaggioService msgS;

	@Autowired
	ITipoCollettoRepository tipoCollettoR;

	@Override
	public void createOrUpdate(TipoCollettoReq req) throws AcademyException {
		// TODO Auto-generated method stub

	}

	@Override
	public TipoCollettoReq searchById(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoCollettoReq searchByDesc(String desc) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
