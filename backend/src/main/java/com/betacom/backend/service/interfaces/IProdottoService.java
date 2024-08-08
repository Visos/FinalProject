package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ProdottoReq;

public interface IProdottoService {
	
	void create(ProdottoReq req) throws AcademyException;

}
