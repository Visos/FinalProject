package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.CamiciaDTO;
import com.betacom.backend.dto.ProdottoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.CamiciaReq;
import com.betacom.backend.request.ProdottoReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.ICamiciaService;
import com.betacom.backend.service.interfaces.IProdottoService;

@RestController
@RequestMapping("/rest/camicia")
public class CamiciaController {
	
	@Autowired
	ICamiciaService camiciaS;
	
	@Autowired
	IProdottoService prodottoS;
	
	@PostMapping("/createOrUpdate")
	public ResponseBase createOrUpdate(@RequestBody(required = true) CamiciaReq req) {
	    ResponseBase resp = new ResponseBase();
	    resp.setRc(true);

	    try {
	        camiciaS.createOrUpdate(req);
	    } catch (Exception e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/searchById")
	public ResponseObject<CamiciaDTO> searchById(@RequestParam Integer id) {

	    ResponseObject<CamiciaDTO> resp = new ResponseObject<CamiciaDTO>();
	    resp.setRc(true);
	    try {
	        resp.setDati(camiciaS.searchById(id));
	    } catch (AcademyException e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/listAll")
	public Response<ProdottoDTO> listAll(@RequestBody (required = false)ProdottoReq req) {

	    Response<ProdottoDTO> resp = new Response<ProdottoDTO>();
	    resp.setRc(true);
	    resp.setDati(prodottoS.findCamiciaByParam(req));

	    return resp;
	}


}
