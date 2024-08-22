package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.betacom.backend.dto.VestitoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.VestitoReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.implementation.VestitoServiceImpl;

@RestController
@RequestMapping(value = "/rest/vestito")
public class VestitoController {
	
	@Autowired
	VestitoServiceImpl vestitoS;
	
	@PostMapping("/createOrUpdate")
    public ResponseBase createOrUpdate(@RequestBody (required = true) VestitoReq req) {
		ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
        	vestitoS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
	}
	
	@GetMapping("/searchById")
	 public ResponseObject<VestitoDTO> searchById(@RequestParam Integer id) {

       ResponseObject<VestitoDTO> resp = new ResponseObject<VestitoDTO>();
       resp.setRc(true);
       try {
           resp.setDati(vestitoS.searchById(id));
       } catch (AcademyException e) {
           resp.setRc(false);
           resp.setMsg(e.getMessage());
       }

       return resp;
   }
	
	 @GetMapping("/listAll")
	    public Response<VestitoDTO> listAll() {

	        Response<VestitoDTO> resp = new Response<VestitoDTO>();
	        resp.setRc(true);
	        resp.setDati(vestitoS.listAll());

	        return resp;
	    }

	

}
