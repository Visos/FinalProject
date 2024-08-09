package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.FantasiaReq;

public interface IFantasiaService {
	void createOrUpdate(FantasiaReq req) throws AcademyException;
	FantasiaReq searchByDesc(String desc) throws AcademyException;
	FantasiaReq searchById(Integer id) throws AcademyException;
	
}
