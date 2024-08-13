package com.betacom.backend.service.implementation;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Vestibilita;
import com.betacom.backend.repository.IVestibilitaRepository;
import com.betacom.backend.request.VestibilitaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IVestibilitaService;

@Service
public class VestibilitaServiceImpl implements IVestibilitaService{
	
	@Autowired
	IMessaggioService msgS;

	@Autowired
	IVestibilitaRepository vestibilitaR;
	
	@Override
	public void createOrUpdate(VestibilitaReq req) throws AcademyException {
		Vestibilita vestibilita = null;
		 
		if(req.getId()!=null) {
			Optional<Vestibilita> opt = vestibilitaR.findById(req.getId());
			if(opt.isPresent())
				vestibilita = opt.get();
			else 
				throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));
		} else
			vestibilita = new Vestibilita();
		
		if(req.getDescrizione()!=null) {
			List<Vestibilita> listVest = vestibilitaR.findAll();
			for(Vestibilita v:listVest) {
				if(req.getDescrizione().equalsIgnoreCase(v.getDesc())) 
					throw new AcademyException(msgS.getMessaggio("vestibilita-exist"));
				}
		} else 
			throw new AcademyException(msgS.getMessaggio("vestibilita-desc-null"));

		
		vestibilita.setDesc(req.getDescrizione());
		
		try {
			vestibilitaR.save(vestibilita);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("vestibilita-generic" + e.getMessage()));
		}
		
	}

	@Override
	public VestibilitaReq searchById(Integer id) throws AcademyException {
		Optional<Vestibilita> opt = vestibilitaR.findById(id);
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));
		
		return new VestibilitaReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

	@Override
	public VestibilitaReq searchByDesc(String desc) throws AcademyException {
		Optional<Vestibilita> opt = vestibilitaR.findByDesc(desc);		
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));

		return new VestibilitaReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

	@Override
	public List<VestibilitaReq> listAll() {
		   return trasformInReq(vestibilitaR.findAll());		
	}
	
	private List<VestibilitaReq> trasformInReq(List<Vestibilita> resp){
		return resp.stream()
				.map(a -> new VestibilitaReq(
						a.getId(),
                        a.getDesc()
						)
					)
				.collect(Collectors.toList());
	}

}
