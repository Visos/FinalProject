package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ColoreReq;
import com.betacom.backend.dto.ColoreDTO;

public interface IColoreService {
	void createOrUpdate(ColoreReq req) throws AcademyException;
	ColoreDTO searchByDesc(String desc) throws AcademyException;
	ColoreDTO searchById(Integer id) throws AcademyException;
	List<ColoreDTO> listAll();
}
