package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.ScarpaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ScarpaReq;

public interface IScarpaService {
	
	void createOrUpdate(ScarpaReq req) throws AcademyException;
	ScarpaDTO searchById(Integer id) throws AcademyException;
	List<ScarpaDTO> listAll();

}
