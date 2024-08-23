package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.ColoreDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ColoreReq;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.implementation.ColoreServiceImpl;

@RestController
@RequestMapping(value = "/rest/colore")
public class ColoreController {
	
	@Autowired
	ColoreServiceImpl coloreS;

	@PostMapping("/createOrUpdate")
	public ResponseBase createOrUpdate(@RequestBody(required = true) ColoreReq req) {
	    ResponseBase resp = new ResponseBase();
	    resp.setRc(true);

	    try {
	        coloreS.createOrUpdate(req);
	    } catch (Exception e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/searchById")
	public ResponseObject<ColoreDTO> searchById(@RequestParam Integer id) {

	    ResponseObject<ColoreDTO> resp = new ResponseObject<ColoreDTO>();
	    resp.setRc(true);
	    try {
	        resp.setDati(coloreS.searchById(id));
	    } catch (AcademyException e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

//	@GetMapping("/listAll")
//	public Response<ColoreDTO> listAll() {
//
//	    Response<ColoreDTO> resp = new Response<ColoreDTO>();
//	    resp.setRc(true);
//	    resp.setDati(coloreS.listAll());
//
//	    return resp;
//	}

	
}
