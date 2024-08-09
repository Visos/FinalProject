package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.TipoScarpaReq;


public interface ITipoScarpaService {
	
	void createOrUpdate(TipoScarpaReq req) throws AcademyException;
	TipoScarpaReq searchById(Integer id) throws AcademyException;
	TipoScarpaReq searchByDesc(String desc) throws AcademyException;


}
