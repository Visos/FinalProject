package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.PantaloneDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.PantaloneReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;

import com.betacom.backend.service.interfaces.IPantaloneService;

@RestController
@RequestMapping("/rest/pantalone")
public class PantaloneController {
	
	@Autowired
	IPantaloneService pantaloneS;
	
	@PostMapping("/createOrUpdate")
	public ResponseBase createOrUpdate(@RequestBody(required = true) PantaloneReq req) {
	    ResponseBase resp = new ResponseBase();
	    resp.setRc(true);

	    try {
	        pantaloneS.createOrUpdate(req);
	    } catch (Exception e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/searchById")
	public ResponseObject<PantaloneDTO> searchById(@RequestParam Integer id) {

	    ResponseObject<PantaloneDTO> resp = new ResponseObject<PantaloneDTO>();
	    resp.setRc(true);
	    try {
	        resp.setDati(pantaloneS.searchById(id));
	    } catch (AcademyException e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/listAll")
	public Response<PantaloneDTO> listAll() {

	    Response<PantaloneDTO> resp = new Response<PantaloneDTO>();
	    resp.setRc(true);
	    resp.setDati(pantaloneS.listAll());

	    return resp;
	}


}
