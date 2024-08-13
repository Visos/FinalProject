package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.MaterialeReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IMaterialeService;

@RestController
@RequestMapping(value = "/rest/materiale")
public class MaterialeController {

    @Autowired
    IMaterialeService materialeS;

    @PostMapping("create")
    public ResponseBase create(@RequestBody (required = true) MaterialeReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            materialeS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchByDesc")
    public ResponseObject<MaterialeReq> searchByDesc(@RequestParam String descrizione) {

        ResponseObject<MaterialeReq> resp = new ResponseObject<MaterialeReq>();
        resp.setRc(true);
        try {
            resp.setDati(materialeS.searchByDesc(descrizione));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchById")
    public ResponseObject<MaterialeReq> searchById(@RequestParam Integer id) {

        ResponseObject<MaterialeReq> resp = new ResponseObject<MaterialeReq>();
        resp.setRc(true);
        try {
            resp.setDati(materialeS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
    
    @GetMapping("listAll")
    public Response<MaterialeReq> listAll() {

        Response<MaterialeReq> resp = new Response<MaterialeReq>();
        resp.setRc(true);
        resp.setDati(materialeS.listAll());

        return resp;
    }
}
