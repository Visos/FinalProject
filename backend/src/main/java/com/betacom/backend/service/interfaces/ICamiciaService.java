package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.CamiciaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Camicia;
import com.betacom.backend.request.CamiciaReq;

public interface ICamiciaService {
	Camicia createOrUpdate(CamiciaReq req) throws AcademyException;

	CamiciaDTO searchById(Integer id) throws AcademyException;

	List<CamiciaDTO> listAll();
}
