package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.PantaloneDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.PantaloneReq;

public interface IPantaloneService{
	

	void createOrUpdate(PantaloneReq req) throws AcademyException;

	PantaloneDTO searchById(Integer id) throws AcademyException;

	List<PantaloneDTO> listAll();

}
