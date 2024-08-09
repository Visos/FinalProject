package com.betacom.backend.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.repository.ITagliaRepository;
import com.betacom.backend.request.TagliaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.ITagliaService;

@Service
public class TagliaServiceImpl implements ITagliaService {
	
	@Autowired
	IMessaggioService msgS;

	@Autowired
	ITagliaRepository tagliaR;

	@Override
	public void createOrUpdate(TagliaReq req) throws AcademyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TagliaReq searchById(Integer id) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TagliaReq searchByDesc(String desc) throws AcademyException {
		// TODO Auto-generated method stub
		return null;
	}

}
