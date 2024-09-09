package com.betacom.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betacom.backend.dto.OrdineDTO;
import com.betacom.backend.dto.ProdottiOrdiniDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.ProdottiOrdini;
import com.betacom.backend.request.OrdineReq;
import com.betacom.backend.request.ProdottiOrdiniReq;
import com.betacom.backend.response.Response;
import com.betacom.backend.response.ResponseBase;
import com.betacom.backend.response.ResponseObject;
import com.betacom.backend.service.interfaces.IOrdineService;
import com.betacom.backend.service.interfaces.IProdottiOrdiniService;
import com.betacom.backend.util.Stato;


@RestController
@RequestMapping("/rest/ordine")
public class OrdineController {

    @Autowired
    IOrdineService ordineS;
    
    @Autowired
    IProdottiOrdiniService prodOrdS;

    @PostMapping("/create")
    public ResponseBase create(@RequestBody (required = true) OrdineReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            ordineS.create(req);
        } catch (Exception e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @PostMapping("/update")
    public ResponseBase update(@RequestBody (required = true) OrdineReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
            ordineS.update(req);
        } catch (Exception e) {
            resp.setRc(false);
            e.printStackTrace();
            resp.setMsg(e.getMessage());
        }

        return resp;
    }
    
    @PostMapping("/addProd")
    public ResponseBase addProd(@RequestBody (required = true) ProdottiOrdiniReq req) {
        
        ResponseBase resp = new ResponseBase();
        resp.setRc(true);

        try {
        	prodOrdS.addProdToCarrello(req);
        } catch (AcademyException e) {
            resp.setRc(false);
            resp.setMsg(e.getMessage());
        }

        return resp;
    }

    @PostMapping("/removeProd")
    public ResponseBase removeProd(@RequestParam (required = true) Integer id){
        ResponseBase res = new ResponseBase();
		res.setRc(true);
		
		try {
            prodOrdS.remove(id);
            } catch (AcademyException e) {
			res.setRc(false);
			res.setMsg(e.getMessage());
		}
		
		return res;
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
	public Response<OrdineDTO> list(Integer id, Stato stato){
		Response<OrdineDTO> resp = new Response<OrdineDTO>();
		resp.setRc(true);
		resp.setDati(ordineS.list(id, stato));
		
		return resp;
	}
    
    @GetMapping("/listProdOrd")
    public Response<ProdottiOrdiniDTO> listAllByOrdine(Integer idOrd){
    	Response<ProdottiOrdiniDTO> resp = new Response<ProdottiOrdiniDTO>();
    	resp.setRc(true);
    	try {
    		List<ProdottiOrdini> l = ordineS.listAllByOrdine(idOrd);
    		resp.setDati(ordineS.transformProdottiOrdiniInDTO(l));
    	} catch (Exception e) {
    		resp.setRc(false);
    		resp.setMsg(e.getMessage());
    	}
    	
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
    
    @GetMapping("/acquista")
    public ResponseObject<OrdineReq> acquista(@RequestParam (required = true) Integer id){
    	  ResponseObject<OrdineReq> resp = new ResponseObject<OrdineReq>();
          resp.setRc(true);
          try {
              ordineS.acquista(id);
          } catch (Exception e) {
             resp.setRc(false);
             resp.setMsg(e.getMessage());
          }
          
          return resp;
    }
    
    @GetMapping("/spedizione")
    public ResponseObject<OrdineReq> spedizione(@RequestParam (required = true) Integer id){
    	  ResponseObject<OrdineReq> resp = new ResponseObject<OrdineReq>();
          resp.setRc(true);
          try {
              ordineS.spedizione(id);
          } catch (Exception e) {
             resp.setRc(false);
             resp.setMsg(e.getMessage());
          }
          
          return resp;
    }
}
