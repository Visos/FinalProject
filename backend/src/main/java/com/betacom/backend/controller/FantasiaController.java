package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.FantasiaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IFantasiaService;

@Controller
@RequestMapping("/rest/fantasia")

public class FantasiaController {
	
	@Autowired
	IFantasiaService fantasiaS;

	
	@PostMapping("/createOrUpdate")
	public ResponseBase createOrUpdate(@RequestBody(required = true) FantasiaReq req) {
	    ResponseBase resp = new ResponseBase();
	    resp.setRc(true);

	    try {
	        fantasiaS.createOrUpdate(req);
	    } catch (Exception e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/searchById")
	public ResponseObject<FantasiaReq> searchById(@RequestParam Integer id) {

	    ResponseObject<FantasiaReq> resp = new ResponseObject<FantasiaReq>();
	    resp.setRc(true);
	    try {
	        resp.setDati(fantasiaS.searchById(id));
	    } catch (AcademyException e) {
	        resp.setRc(false);
	        resp.setMsg(e.getMessage());
	    }

	    return resp;
	}

	@GetMapping("/listAll")
	public Response<FantasiaReq> listAll() {

	    Response<FantasiaReq> resp = new Response<FantasiaReq>();
	    resp.setRc(true);
	    resp.setDati(fantasiaS.listAll());

	    return resp;
	}

}
