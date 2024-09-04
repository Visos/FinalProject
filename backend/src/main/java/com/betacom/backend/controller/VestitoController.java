package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.ProdottoDTO;
import com.betacom.backend.dto.VestitoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ProdottoReq;
import com.betacom.backend.request.VestitoReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IProdottoService;
import com.betacom.backend.service.interfaces.IVestitoService;

@RestController
@RequestMapping(value = "/rest/vestito")
public class VestitoController {
	
	@Autowired
	IVestitoService vestitoS;
	
	@Autowired
	IProdottoService prodS;
	
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
	    public Response<ProdottoDTO> listAll(@RequestBody (required = false)ProdottoReq req) {

	        Response<ProdottoDTO> resp = new Response<ProdottoDTO>();
	        resp.setRc(true);
	        resp.setDati(prodS.findVestitoByParam(req));

	        return resp;
	    }

	

}
