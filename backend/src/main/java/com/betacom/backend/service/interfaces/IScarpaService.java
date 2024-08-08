package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ScarpaReq;

public interface IScarpaService {
	
	void create(ScarpaReq req) throws AcademyException;

}
