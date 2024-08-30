package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.VestitoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Vestito;
import com.betacom.backend.request.VestitoReq;

public interface IVestitoService {
	
	Vestito createOrUpdate(VestitoReq req) throws AcademyException;
	public VestitoDTO searchById (Integer id) throws AcademyException;
	public List<VestitoDTO> listAll();

}
