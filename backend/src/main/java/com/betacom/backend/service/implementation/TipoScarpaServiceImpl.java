package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.TipoScarpa;
import com.betacom.backend.repository.ITipoScarpaRepository;
import com.betacom.backend.request.TipoScarpaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.ITipoScarpaService;

@Service
public class TipoScarpaServiceImpl implements ITipoScarpaService {

	@Autowired
	IMessaggioService msgS;
	
	@Autowired
	ITipoScarpaRepository tipoScarpaR;
	
	
	
	@Override
	public void createOrUpdate(TipoScarpaReq req) throws AcademyException {
		TipoScarpa tipoScarpa = null;
		
		if(req.getId()!=null) {
			Optional<TipoScarpa> opt = tipoScarpaR.findById(req.getId());
			if(opt.isPresent())
				tipoScarpa = opt.get();
			else 
				throw new AcademyException(msgS.getMessaggio("tipoScarpa-ntexist"));
			} else
				tipoScarpa = new TipoScarpa();
		
		if(req.getDescrizione()!=null) {
			List<TipoScarpa> listTipoScarpa = tipoScarpaR.findAll();
			for (TipoScarpa tS:listTipoScarpa) {
				if(req.getDescrizione().equalsIgnoreCase(tS.getDesc()))
					throw new AcademyException(msgS.getMessaggio("tipoScarpa-exist"));
			}
		} else 
			throw new AcademyException(msgS.getMessaggio("tipoScarpa-desc-null"));
		
		tipoScarpa.setDesc(req.getDescrizione());
		
		try {
			tipoScarpaR.save(tipoScarpa);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("tipoScarpa-generic" + e.getMessage()));
		}
	
	}
		
	
	

	@Override
	public TipoScarpaReq searchById(Integer id) throws AcademyException {
		Optional<TipoScarpa> opt = tipoScarpaR.findById(id);
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("tipoScarpa-ntexist"));
		
		return new TipoScarpaReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

	@Override
	public TipoScarpaReq searchByDesc(String desc) throws AcademyException {
		Optional<TipoScarpa> opt = tipoScarpaR.findByDesc(desc);
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("tipoScarpa-ntexist"));
		
		return new TipoScarpaReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

	@Override
	public List<TipoScarpaReq> listAll() {
		 return trasformInReq(tipoScarpaR.findAll());
	}

	 private List<TipoScarpaReq> trasformInReq(List<TipoScarpa> resp){
			return resp.stream()
					.map(a -> new TipoScarpaReq(
							a.getId(),
	                        a.getDesc()
							)
						)
					.collect(Collectors.toList());
		}

	
	
}
