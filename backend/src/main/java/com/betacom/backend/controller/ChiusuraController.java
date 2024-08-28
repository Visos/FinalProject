package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ChiusuraReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IChiusuraService;


@Controller
@RequestMapping(value = "/rest/chiusura")
public class ChiusuraController {
	
	@Autowired
	IChiusuraService chiusuraS;

	
	
	@PostMapping("/createOrUpdate")
	public ResponseBase createOrUpdate(@RequestBody(required = true) ChiusuraReq req) {
	    ResponseBase resp = new ResponseBase();
	    resp.setRc(true);

	    try {
	        chiusuraS.createOrUpdate(req);
	    } catch (Exception e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/searchById")
	public ResponseObject<ChiusuraReq> searchById(@RequestParam Integer id) {

	    ResponseObject<ChiusuraReq> resp = new ResponseObject<ChiusuraReq>();
	    resp.setRc(true);
	    try {
	        resp.setDati(chiusuraS.searchById(id));
	    } catch (AcademyException e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/listAll")
	public Response<ChiusuraReq> listAll() {

	    Response<ChiusuraReq> resp = new Response<ChiusuraReq>();
	    resp.setRc(true);
	    resp.setDati(chiusuraS.listAll());

	    return resp;
	}


}
