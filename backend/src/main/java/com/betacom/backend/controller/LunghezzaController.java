package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.LunghezzaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.ILunghezzaService;



@RestController
@RequestMapping(value = "/rest/lunghezza")
public class LunghezzaController {

    @Autowired
    ILunghezzaService lunghezzaS;

    @PostMapping("/createOrUpdate")
    public ResponseBase create(@RequestBody (required = true) LunghezzaReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            lunghezzaS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("/searchByDesc")
    public ResponseObject<LunghezzaReq> searchByDesc(@RequestParam String descrizione) {

        ResponseObject<LunghezzaReq> resp = new ResponseObject<LunghezzaReq>();
        resp.setRc(true);
        try {
            resp.setDati(lunghezzaS.searchByDesc(descrizione));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("/searchById")
    public ResponseObject<LunghezzaReq> searchById(@RequestParam Integer id) {

        ResponseObject<LunghezzaReq> resp = new ResponseObject<LunghezzaReq>();
        resp.setRc(true);
        try {
            resp.setDati(lunghezzaS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
    
    @GetMapping("/listAll")
    public Response<LunghezzaReq> listAll() {

        Response<LunghezzaReq> resp = new Response<LunghezzaReq>();
        resp.setRc(true);
        resp.setDati(lunghezzaS.listAll());

        return resp;
    }
    
}
