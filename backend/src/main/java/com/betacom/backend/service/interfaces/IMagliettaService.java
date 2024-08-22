package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.MagliettaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.MagliettaReq;

public interface IMagliettaService {

	void createOrUpdate(MagliettaReq req) throws AcademyException;

	MagliettaDTO searchById(Integer id) throws AcademyException;

	List<MagliettaDTO> listAll();
	
}
