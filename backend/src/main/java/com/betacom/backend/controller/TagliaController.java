package com.betacom.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.TagliaReq;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.ITagliaService;

@RestController
@RequestMapping(value = "/rest/taglia")
public class TagliaController {
	
	@Autowired
	ITagliaService tagliaS;
	
	 @PostMapping("create")
    public ResponseBase create(@RequestBody (required = true) TagliaReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            tagliaS.createOrUpdate(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchByDesc")
    public ResponseObject<TagliaReq> searchByDesc(@RequestParam String descrizione) {

        ResponseObject<TagliaReq> resp = new ResponseObject<TagliaReq>();
        resp.setRc(true);
        try {
            resp.setDati(tagliaS.searchByDesc(descrizione));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @GetMapping("searchById")
    public ResponseObject<TagliaReq> searchById(@RequestParam Integer id) {

        ResponseObject<TagliaReq> resp = new ResponseObject<TagliaReq>();
        resp.setRc(true);
        try {
            resp.setDati(tagliaS.searchById(id));
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

}
