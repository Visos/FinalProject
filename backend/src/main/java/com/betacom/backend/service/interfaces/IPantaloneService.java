package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.PantaloneReq;

public interface IPantaloneService{
	
	void create(PantaloneReq req) throws AcademyException;

}
