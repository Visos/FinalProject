package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.pojo.ProdottiOrdini;
import com.betacom.backend.pojo.Prodotto;
import com.betacom.backend.repository.IOrdineRepository;
import com.betacom.backend.repository.IProdottiOrdiniRepository;
import com.betacom.backend.request.ProdottiOrdiniReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IOrdineService;
import com.betacom.backend.service.interfaces.IProdottiOrdiniService;
import com.betacom.backend.service.interfaces.IProdottoService;

@Service
public class ProdottiOrdiniServiceImpl implements IProdottiOrdiniService {

	@Autowired
	IProdottiOrdiniRepository prodOrdR;

	@Autowired
	IOrdineRepository ordineR;

	@Autowired
	IOrdineService ordineS;

	@Autowired
	IProdottoService prodottoS;

	@Autowired
	IMessaggioService msgS;

	@Override
	public ProdottiOrdini createOrUpdate(ProdottiOrdiniReq req) throws AcademyException {

		ProdottiOrdini prodOrd = null;

		if (req.getId() != null) {
			Optional<ProdottiOrdini> optional = prodOrdR.findById(req.getId());
			if (optional.isPresent()) {
				prodOrd = optional.get();
			} else {
				throw new AcademyException(msgS.getMessaggio("prodOrdini-ntexist"));
			}
		} else {
			prodOrd = new ProdottiOrdini();
		}

		prodOrd.setQty(req.getQty());
		prodOrd.setOrdine(ordineS.getOrdine(req.getIdOrdine()));
		prodOrd.setProdotto(prodottoS.getProdotto(req.getIdProdotto()));

		try {
			return prodOrdR.save(prodOrd);

		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("prodOrdini-generic") + e.getMessage());
		}

	}

	@Override
	public ProdottiOrdiniReq searchById(Integer id) throws AcademyException {
		Optional<ProdottiOrdini> optional = prodOrdR.findById(id);
		if (optional.isEmpty())
			throw new AcademyException(msgS.getMessaggio("prodOrdini-ntexist"));

		return new ProdottiOrdiniReq(optional.get().getId(), optional.get().getQty(),
				optional.get().getOrdine().getId(), optional.get().getProdotto().getId());
	}

	@Override
	public void remove(Integer id) throws AcademyException {
		Optional<ProdottiOrdini> optional = prodOrdR.findById(id);
		if (optional.isPresent()) {
			Prodotto p = optional.get().getProdotto();
			p.setQty(p.getQty() + optional.get().getQty());
			prodOrdR.delete(optional.get());
			
		} else {
			throw new AcademyException(msgS.getMessaggio("prodOrdini-ntexist"));
		}
	}

	@Override
	public void addProdToCarrello(ProdottiOrdiniReq req) throws AcademyException {

		Ordine ordine = ordineS.getOrdine(req.getIdOrdine());

		Prodotto prodotto = prodottoS.getProdotto(req.getIdProdotto());

		List<ProdottiOrdini> list = ordine.getProdOrdini();

		if (list.isEmpty()) {
			ProdottiOrdini prodOrd = createOrUpdate(req);
			list.add(prodOrd);
		} else {
			Optional<ProdottiOrdini> opt = prodOrdR.findByOrdineAndProdotto(ordine, prodotto);
			if (opt.isPresent()) {
				ProdottiOrdini p = opt.get();
				Integer newQty = p.getQty() + req.getQty();
				p.setQty(newQty);
				Prodotto prod = p.getProdotto();
				prod.setQty(prodotto.getQty() - req.getQty());	
				
				System.out.println(prodotto.getQty() - req.getQty());
			} else {
				ProdottiOrdini prodOrd = createOrUpdate(req);
				list.add(prodOrd);
				Prodotto prod = prodOrd.getProdotto();
				prod.setQty(prodotto.getQty() - req.getQty());	
			}
		}
		ordineR.save(ordine);
	}

}
