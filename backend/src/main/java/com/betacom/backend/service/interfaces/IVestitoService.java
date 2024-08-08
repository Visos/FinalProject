package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.VestitoReq;

public interface IVestitoService {
	
	void create(VestitoReq req) throws AcademyException;

}
