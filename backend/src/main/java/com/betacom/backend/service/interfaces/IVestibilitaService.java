package com.betacom.backend.service.interfaces;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Vestibilita;
import com.betacom.backend.request.VestibilitaReq;

public interface IVestibilitaService {
	
	void createOrUpdate(VestibilitaReq req) throws AcademyException;
	VestibilitaReq searchById(Integer id) throws AcademyException;
	VestibilitaReq searchByDesc(String desc) throws AcademyException;

}
