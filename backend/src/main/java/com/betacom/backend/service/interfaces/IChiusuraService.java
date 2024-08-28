package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ChiusuraReq;

public interface IChiusuraService {

	void createOrUpdate(ChiusuraReq req) throws AcademyException;
	ChiusuraReq searchByDesc(String desc) throws AcademyException;
	ChiusuraReq searchById(Integer id) throws AcademyException;
	List<ChiusuraReq> listAll();
	

}
