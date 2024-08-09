package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.TipoCollettoReq;

public interface ITipoCollettoService {
	
	void createOrUpdate(TipoCollettoReq req) throws AcademyException;
	TipoCollettoReq searchById(Integer id) throws AcademyException;
	TipoCollettoReq searchByDesc(String descrizione) throws AcademyException;

}
