package com.betacom.backend.service.interfaces;

import java.util.List;

import com.betacom.backend.dto.ProdottoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Prodotto;
import com.betacom.backend.request.ProdottoReq;

public interface IProdottoService {
	
	void createOrUpdate(ProdottoReq req) throws AcademyException;
	void remove(ProdottoReq req) throws AcademyException;
	List<ProdottoDTO> listAll();
	ProdottoDTO searchById(Integer id) throws AcademyException;
	List<ProdottoDTO> trasformInDTO(List<Prodotto> resp);
	Prodotto getProdotto(Integer id) throws AcademyException;
	List<ProdottoDTO> listByParam(ProdottoReq req);
	List<ProdottoDTO> findMaglietteByParam(ProdottoReq req);
	List<ProdottoDTO> findPantaloneByParam(ProdottoReq req);
	List<ProdottoDTO> findVestitoByParam(ProdottoReq req);
	List<ProdottoDTO> findScarpaByParam(ProdottoReq req);
	List<ProdottoDTO> findCamiciaByParam(ProdottoReq req);



}
