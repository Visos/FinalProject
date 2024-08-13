package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.VestibilitaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IVestibilitaService;

@RestController
@RequestMapping(value = "/rest/vestibilita")
public class VestibilitaController {
	
	  @Autowired
	    IVestibilitaService vestibilitaS;

	    @PostMapping("create")
	    public ResponseBase create(@RequestBody (required = true) VestibilitaReq req) {
	        
	        ResponseBase resp = new ResponseBase();
	        resp.setRc(true);

	        try {
	        	vestibilitaS.createOrUpdate(req);
	        } catch (Exception e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }

	    @GetMapping("searchByDesc")
	    public ResponseObject<VestibilitaReq> searchByDesc(@RequestParam String descrizione) {

	        ResponseObject<VestibilitaReq> resp = new ResponseObject<VestibilitaReq>();
	        resp.setRc(true);
	        try {
	            resp.setDati(vestibilitaS.searchByDesc(descrizione));
	        } catch (AcademyException e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }

	    @GetMapping("searchById")
	    public ResponseObject<VestibilitaReq> searchById(@RequestParam Integer id) {

	        ResponseObject<VestibilitaReq> resp = new ResponseObject<VestibilitaReq>();
	        resp.setRc(true);
	        try {
	            resp.setDati(vestibilitaS.searchById(id));
	        } catch (AcademyException e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }
	    
	    @GetMapping("listAll")
	    public Response<VestibilitaReq> listAll() {

	        Response<VestibilitaReq> resp = new Response<VestibilitaReq>();
	        resp.setRc(true);
	        resp.setDati(vestibilitaS.listAll());

	        return resp;
	    }

}
