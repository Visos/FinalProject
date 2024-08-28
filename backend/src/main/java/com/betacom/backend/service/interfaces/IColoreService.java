package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ColoreReq;

public interface IColoreService {
	void createOrUpdate(ColoreReq req) throws AcademyException;
	ColoreReq searchByDesc(String desc) throws AcademyException;
	ColoreReq searchById(Integer id) throws AcademyException;
	List<ColoreReq> listAll();
}
