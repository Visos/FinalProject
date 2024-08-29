package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.MagliettaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.MagliettaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IMagliettaService;

@RestController
@RequestMapping("/rest/maglietta")
public class MagliettaController {
    
    @Autowired
    IMagliettaService magliettaS;
    
    @PostMapping("/createOrUpdate")
    public ResponseBase createOrUpdate(@RequestBody(required = true) MagliettaReq req) {
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            magliettaS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("/searchById")
    public ResponseObject<MagliettaDTO> searchById(@RequestParam Integer id) {

        ResponseObject<MagliettaDTO> resp = new ResponseObject<MagliettaDTO>();
        resp.setRc(true);
        try {
            resp.setDati(magliettaS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("/listAll")
    public Response<MagliettaDTO> listAll() {

        Response<MagliettaDTO> resp = new Response<MagliettaDTO>();
        resp.setRc(true);
        resp.setDati(magliettaS.listAll());

        return resp;
    }
}
