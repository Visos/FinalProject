package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.ProdottoDTO;
import com.betacom.backend.dto.ScarpaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ProdottoReq;
import com.betacom.backend.request.ScarpaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.implementation.ScarpaServiceImpl;
import com.betacom.backend.service.interfaces.IProdottoService;
import com.betacom.backend.service.interfaces.IScarpaService;

@RestController
@RequestMapping(value = "/rest/scarpa")
public class ScarpaController {
	
	@Autowired
	IScarpaService scarpaS;
	
	@Autowired
	IProdottoService prodS;
	
	@PostMapping("/createOrUpdate")
    public ResponseBase createOrUpdate(@RequestBody (required = true) ScarpaReq req) {
		ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
        	scarpaS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
	}
	
	@GetMapping("/searchById")
	 public ResponseObject<ScarpaDTO> searchById(@RequestParam Integer id) {

        ResponseObject<ScarpaDTO> resp = new ResponseObject<ScarpaDTO>();
        resp.setRc(true);
        try {
            resp.setDati(scarpaS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
	
	 @GetMapping("/listAll")
	    public Response<ProdottoDTO> listAll(@RequestBody ProdottoReq req) {

	        Response<ProdottoDTO> resp = new Response<ProdottoDTO>();
	        resp.setRc(true);
	        resp.setDati(prodS.findScarpaByParam(req));

	        return resp;
	    }


}
