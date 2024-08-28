package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.OrdineDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.OrdineReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IOrdineService;


@RestController
@RequestMapping("/rest/ordine")
public class OrdineController {

    @Autowired
    IOrdineService ordineS;

    @PostMapping("/createOrUpdate")
    public ResponseBase createOrUpdate(@RequestBody (required = true) OrdineReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            ordineS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @PostMapping("/remove")
    public ResponseBase remove(@RequestParam (required = true) Integer id){
        ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
            ordineS.remove(id);
            } catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
	}

    @GetMapping("/list")
	public Response<OrdineDTO> list(Integer id, String stato){
		Response<OrdineDTO> resp = new Response<OrdineDTO>();
		resp.setRc(true);
		resp.setDati(ordineS.list(id, stato));
		
		return resp;
	}

    @GetMapping("/findById")
    public ResponseObject<OrdineReq> findById(@RequestParam (required = true) Integer id) {
        
        ResponseObject<OrdineReq> resp = new ResponseObject<OrdineReq>();
        resp.setRc(true);
        try {
            resp.setDati(ordineS.searchById(id));
        } catch (Exception e) {
           resp.setRc(false);
           resp.setMsg(e.getMessage());
        }
        
        return resp;
    }
}
