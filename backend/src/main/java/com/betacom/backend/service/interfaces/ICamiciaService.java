package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.CamiciaReq;

public interface ICamiciaService {
	void create(CamiciaReq req) throws AcademyException;
}
