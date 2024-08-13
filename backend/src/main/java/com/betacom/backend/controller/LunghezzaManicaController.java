package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.LunghezzaManicaReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.ILunghezzaManicaService;

@RestController
@RequestMapping("/rest/lunghezzaManica")
public class LunghezzaManicaController {

    @Autowired
    ILunghezzaManicaService lManicaS;

    @PostMapping("create")
    public ResponseBase create(@RequestBody (required = true) LunghezzaManicaReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            lManicaS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchByDesc")
    public ResponseObject<LunghezzaManicaReq> searchByDesc(@RequestParam String descrizione) {

        ResponseObject<LunghezzaManicaReq> resp = new ResponseObject<LunghezzaManicaReq>();
        resp.setRc(true);
        try {
            resp.setDati(lManicaS.searchByDesc(descrizione));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    } 

    @GetMapping("searchById")
    public ResponseObject<LunghezzaManicaReq> searchById(@RequestParam Integer id) {

        ResponseObject<LunghezzaManicaReq> resp = new ResponseObject<LunghezzaManicaReq>();
        resp.setRc(true);
        try {
            resp.setDati(lManicaS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
    
    @GetMapping("listAll")
    public Response<LunghezzaManicaReq> listAll() {

        Response<LunghezzaManicaReq> resp = new Response<LunghezzaManicaReq>();
        resp.setRc(true);
        resp.setDati(lManicaS.listAll());

        return resp;
    }
}
