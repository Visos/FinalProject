package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.TipoScarpaReq;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.ITipoScarpaService;

@RestController
@RequestMapping(value = "/rest/tipoScarpa")
public class TipoScarpaController {
	
	 @Autowired
	 ITipoScarpaService tipoScarpaS;

	    @PostMapping("create")
	    public ResponseBase create(@RequestBody (required = true) TipoScarpaReq req) {
	        
	        ResponseBase resp = new ResponseBase();
	        resp.setRc(true);

	        try {
	            tipoScarpaS.createOrUpdate(req);
	        } catch (Exception e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }

	    @GetMapping("searchByDesc")
	    public ResponseObject<TipoScarpaReq> searchByDesc(@RequestParam String descrizione) {

	        ResponseObject<TipoScarpaReq> resp = new ResponseObject<TipoScarpaReq>();
	        resp.setRc(true);
	        try {
	            resp.setDati(tipoScarpaS.searchByDesc(descrizione));
	        } catch (AcademyException e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }

	    @GetMapping("searchById")
	    public ResponseObject<TipoScarpaReq> searchById(@RequestParam Integer id) {

	        ResponseObject<TipoScarpaReq> resp = new ResponseObject<TipoScarpaReq>();
	        resp.setRc(true);
	        try {
	            resp.setDati(tipoScarpaS.searchById(id));
	        } catch (AcademyException e) {
	            resp.setRc(false);
	            resp.setMsg(e.getMessage());
	        }

	        return resp;
	    }

}
