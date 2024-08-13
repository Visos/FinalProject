package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.TipoColletto;
import com.betacom.backend.repository.ITipoCollettoRepository;
import com.betacom.backend.request.TipoCollettoReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.ITipoCollettoService;

@Service
public class TipoCollettoServiceImpl implements ITipoCollettoService {
	@Autowired
	IMessaggioService msgS;

	@Autowired
	ITipoCollettoRepository tipoCollettoR;

	@Override
	public void createOrUpdate(TipoCollettoReq req) throws AcademyException {
		TipoColletto tipoColletto = null;
		
		if(req.getId()!=null) {
			Optional<TipoColletto> opt = tipoCollettoR.findById(req.getId());
			if(opt.isPresent())
				tipoColletto = opt.get();
			else 
				throw new AcademyException(msgS.getMessaggio("tipoColletto-ntexist"));
		} else
			tipoColletto = new TipoColletto();
		
		if(req.getDescrizione()!=null) {
			List<TipoColletto> listTipoColletto = tipoCollettoR.findAll();
			for (TipoColletto tC:listTipoColletto) {
				if(req.getDescrizione().equalsIgnoreCase(tC.getDesc()))
					throw new AcademyException(msgS.getMessaggio("tipoColletto-exist"));
			}
		} else 
			throw new AcademyException(msgS.getMessaggio("tipoColletto-desc-null"));

		
		tipoColletto.setDesc(req.getDescrizione());
		
		try {
			tipoCollettoR.save(tipoColletto);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("tipoColletto-generic" + e.getMessage()));
		}
	}

	@Override
	public TipoCollettoReq searchById(Integer id) throws AcademyException {
		Optional<TipoColletto> opt = tipoCollettoR.findById(id);
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("tipoColletto-ntexist"));
		
		return new TipoCollettoReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

	@Override
	public TipoCollettoReq searchByDesc(String desc) throws AcademyException {
		Optional<TipoColletto> opt = tipoCollettoR.findByDesc(desc);
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("tipoColletto-ntexist"));
		
		return new TipoCollettoReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

}
