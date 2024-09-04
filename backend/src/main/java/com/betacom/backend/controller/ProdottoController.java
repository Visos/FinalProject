package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.ProdottoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.ProdottoReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.implementation.ProdottoServiceImpl;

@RestController
@RequestMapping(value = "/rest/prodotto")
public class ProdottoController {
	
	@Autowired
	ProdottoServiceImpl prodottoS;
	
	@PostMapping("/createOrUpdate")
    public ResponseBase createOrUpdate(@RequestBody (required = true) ProdottoReq req) {
		ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
        	prodottoS.create(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
	}
	
	@GetMapping("/searchById")
	 public ResponseObject<ProdottoDTO> searchById(@RequestParam Integer id) {

      ResponseObject<ProdottoDTO> resp = new ResponseObject<ProdottoDTO>();
      resp.setRc(true);
      try {
          resp.setDati(prodottoS.searchById(id));
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
            resp.setDati(prodottoS.listByParam(req));

	        return resp;
	    }

}
