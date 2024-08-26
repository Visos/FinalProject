package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.ProdottoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ProdottoReq;

public interface IProdottoService {
	
	void create(ProdottoReq req) throws AcademyException;
	List<ProdottoDTO> listAll();
	ProdottoDTO searchById(Integer id) throws AcademyException;

}
