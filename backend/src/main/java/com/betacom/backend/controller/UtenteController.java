package com.betacom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.UtenteDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.UtenteReq;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IUtenteService;

@RestController
@RequestMapping(value = "/rest/utente")
public class UtenteController {

    @Autowired
    IUtenteService utenteS;

    @RequestMapping("/createOrUpdate")
    public ResponseBase createOrUpdate(@RequestBody (required = true) UtenteReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            utenteS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchByMail")
    public ResponseObject<UtenteDTO> searchByDesc(@RequestParam String mail) {

        ResponseObject<UtenteDTO> resp = new ResponseObject<UtenteDTO>();
        resp.setRc(true);
        try {
            resp.setDati(utenteS.searchByMail(mail));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchById")
    public ResponseObject<UtenteDTO> searchById(@RequestParam Integer id) {

        ResponseObject<UtenteDTO> resp = new ResponseObject<UtenteDTO>();
        resp.setRc(true);
        try {
            resp.setDati(utenteS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
    
    @GetMapping("listAll")
    public List<UtenteDTO> listAll() {

        return utenteS.listAll();
    }
    
}
