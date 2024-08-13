package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.MarcaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IMarcaService;

@RestController
@RequestMapping(value = "/rest/marca")
public class MarcaController {

    @Autowired 
    IMarcaService marcaS;

    @PostMapping("create")
    public ResponseBase create(@RequestBody (required = true) MarcaReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            marcaS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchByDesc")
    public ResponseObject<MarcaReq> searchByDesc(@RequestParam String descrizione) {

        ResponseObject<MarcaReq> resp = new ResponseObject<MarcaReq>();
        resp.setRc(true);
        try {
            resp.setDati(marcaS.searchByDesc(descrizione));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchById")
    public ResponseObject<MarcaReq> searchById(@RequestParam Integer id) {

        ResponseObject<MarcaReq> resp = new ResponseObject<MarcaReq>();
        resp.setRc(true);
        try {
            resp.setDati(marcaS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
    
    @GetMapping("listAll")
    public Response<MarcaReq> listAll() {

        Response<MarcaReq> resp = new Response<MarcaReq>();
        resp.setRc(true);
        resp.setDati(marcaS.listAll());

        return resp;
    }
}
