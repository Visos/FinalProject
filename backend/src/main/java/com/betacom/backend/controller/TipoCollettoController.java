package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.TipoCollettoReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.ITipoCollettoService;

@RestController
@RequestMapping(value = "/rest/tipoColletto")
public class TipoCollettoController {
	   
	@Autowired
	    ITipoCollettoService tipoCollettoS;

	    @PostMapping("/createOrUpdate")
	    public ResponseBase create(@RequestBody (required = true) TipoCollettoReq req) {
	        
	        ResponseBase resp = new ResponseBase();
	        resp.setRc(true);

	        try {
	            tipoCollettoS.createOrUpdate(req);
	        } catch (Exception e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }

	    @GetMapping("/searchByDesc")
	    public ResponseObject<TipoCollettoReq> searchByDesc(@RequestParam String descrizione) {

	        ResponseObject<TipoCollettoReq> resp = new ResponseObject<TipoCollettoReq>();
	        resp.setRc(true);
	        try {
	            resp.setDati(tipoCollettoS.searchByDesc(descrizione));
	        } catch (AcademyException e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }

	    @GetMapping("/searchById")
	    public ResponseObject<TipoCollettoReq> searchById(@RequestParam Integer id) {

	        ResponseObject<TipoCollettoReq> resp = new ResponseObject<TipoCollettoReq>();
	        resp.setRc(true);
	        try {
	            resp.setDati(tipoCollettoS.searchById(id));
	        } catch (AcademyException e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }
	    
	    @GetMapping("/listAll")
	    public Response<TipoCollettoReq> listAll() {

	        Response<TipoCollettoReq> resp = new Response<TipoCollettoReq>();
	        resp.setRc(true);
	        resp.setDati(tipoCollettoS.listAll());

	        return resp;
	    }
	}


