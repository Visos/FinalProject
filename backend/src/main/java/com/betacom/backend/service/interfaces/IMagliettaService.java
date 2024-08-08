package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.MagliettaReq;

public interface IMagliettaService {
	void create(MagliettaReq req) throws AcademyException;
	
}
