package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.TagliaReq;

public interface ITagliaService {
	
	void createOrUpdate(TagliaReq req) throws AcademyException;
	TagliaReq searchById(Integer id) throws AcademyException;
	TagliaReq searchByDesc(String desc) throws AcademyException;
	List<TagliaReq> listAll();

}
