package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.betacom.backend.dto.OrdineDTO;
import com.betacom.backend.dto.ProdottiOrdiniDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.pojo.ProdottiOrdini;
import com.betacom.backend.repository.IOrdineRepository;
import com.betacom.backend.request.OrdineReq;
import com.betacom.backend.request.ProdottiOrdiniReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IOrdineService;
import com.betacom.backend.service.interfaces.IUtenteService;
import com.betacom.backend.util.Stato;

@Service
public class OrdineServiceImpl implements IOrdineService  {

    @Autowired
    IOrdineRepository ordineR;

    @Autowired
    IUtenteService utenteS;

    @Autowired
    IMessaggioService msgS;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrUpdate(OrdineReq req) throws AcademyException {
        
        Ordine ordine = null;
        if (newOrdine(req.getIdUtente())) {
            ordine = new Ordine();
        } else {
            Optional<Ordine> optional = ordineR.findById(req.getId());
            if (optional.isPresent()) {
                ordine = optional.get();
            }
        }

        ordine.setStato(Stato.CARRELLO);

        ordine.setUtente(utenteS.getUtente(req.getIdUtente()));
        ordine.setProdOrdini(listAllByOrdine(ordine.getId()));

        Double prezzo = 0.0;
        for (ProdottiOrdini ordini : ordine.getProdOrdini()) {
            prezzo += ordini.getProdotto().getPrezzo() * ordini.getQty();
        }
        ordine.setPrezzoTotale(prezzo);

        Integer quantita = 0;
        for (ProdottiOrdini ordini : ordine.getProdOrdini()) {
            quantita += ordini.getProdotto().getQty();
        }
        ordine.setQty(quantita);
        
        try {
            ordineR.save(ordine);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("ordine-generic") + e.getMessage());
        }
    }

    public Boolean newOrdine(Integer id){
        if (list(id, Stato.CARRELLO).isEmpty()){
            return true;
        } else return false;
    }

    @Override
    public OrdineReq searchById(Integer id) throws AcademyException {
        Optional<Ordine> optional = ordineR.findById(id);
        if (optional.isEmpty())
            throw new AcademyException(msgS.getMessaggio("prodOrdini-ntexist"));
        
        return new OrdineReq(
                optional.get().getId(),
                optional.get().getData(),
                optional.get().getStato().name(),
                optional.get().getPrezzoTotale(),
                optional.get().getQty(),
                optional.get().getUtente().getId(),
                transformProdottiOrdiniInReq(optional.get().getProdOrdini())
        );
    }

    @Override
    public List<OrdineDTO> list(Integer id, Stato stato) {
        List<Ordine> ord = ordineR.findByParam(id, stato);
        return transformInDTO(ord);
    }

    private List<OrdineDTO> transformInDTO(List<Ordine> resp){
		return resp.stream()
				.map(a -> new OrdineDTO(
						a.getId(),
                        a.getData(),
                        a.getStato().name(),
                        a.getPrezzoTotale(),
                        a.getQty(),
                        a.getUtente().getId(),
                        transformProdottiOrdiniInDTO(a.getProdOrdini())
						)
					)
				.collect(Collectors.toList());
	}

    private List<ProdottiOrdiniDTO> transformProdottiOrdiniInDTO(List<ProdottiOrdini> resp){
		return resp.stream()
				.map(a -> new ProdottiOrdiniDTO(
						a.getId(),
                        a.getQty(),
                        a.getOrdine().getId(),
                        a.getProdotto().getId()
						)
					)
				.collect(Collectors.toList());
	}

    private List<ProdottiOrdiniReq> transformProdottiOrdiniInReq(List<ProdottiOrdini> resp){
		return resp.stream()
				.map(a -> new ProdottiOrdiniReq(
						a.getId(),
                        a.getQty(),
                        a.getOrdine().getId(),
                        a.getProdotto().getId()
						)
					)
				.collect(Collectors.toList());
	}

    @Override
    public Ordine getOrdine(Integer id) throws AcademyException {
       
        Optional<Ordine> optional = ordineR.findById(id);
        
        if (optional.isEmpty()) {
            throw new AcademyException(msgS.getMessaggio("ordine-ntexist"));
        } else
            return optional.get();
    }

    @Override
    public void remove(Integer id) throws AcademyException {
       Optional<Ordine> optional = ordineR.findById(id);
        if (optional.isPresent()) {
            optional.get().getProdOrdini().clear();
            ordineR.save(optional.get());
            ordineR.delete(optional.get());
        } else {
            throw new AcademyException(msgS.getMessaggio("ordine-ntexist"));
        }
    }

    @Override
    public List<ProdottiOrdini> listAllByOrdine(Integer id) throws AcademyException {
        Optional<Ordine> optional = ordineR.findById(id);
        if (optional.isPresent()) {
            return optional.get().getProdOrdini();
        } else {
            throw new AcademyException(msgS.getMessaggio("ordine-ntexist"));
        }
    }
}
