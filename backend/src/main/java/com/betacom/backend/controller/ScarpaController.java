package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.betacom.backend.dto.ScarpaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ScarpaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.implementation.ScarpaServiceImpl;

@RestController
@RequestMapping(value = "/rest/scarpa")
public class ScarpaController {
	
	@Autowired
	ScarpaServiceImpl scarpaS;
	
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
	    public Response<ScarpaDTO> listAll() {

	        Response<ScarpaDTO> resp = new Response<ScarpaDTO>();
	        resp.setRc(true);
	        resp.setDati(scarpaS.listAll());

	        return resp;
	    }


}
