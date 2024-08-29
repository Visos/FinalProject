package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.dto.ScarpaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Chiusura;
import com.betacom.backend.pojo.Scarpa;
import com.betacom.backend.pojo.TipoScarpa;
import com.betacom.backend.repository.IChiusuraRepository;
import com.betacom.backend.repository.IScarpaRepository;
import com.betacom.backend.repository.ITipoScarpaRepository;
import com.betacom.backend.request.ScarpaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IScarpaService;


@Service
public class ScarpaServiceImpl implements IScarpaService {
	
	@Autowired
	IMessaggioService msgS;
	
	@Autowired
	IScarpaRepository scarpaR;
	
	@Autowired
	IChiusuraRepository chiusuraR;
	
	@Autowired 
	ITipoScarpaRepository tipoScarpaR;

	@Override
	public void createOrUpdate(ScarpaReq req) throws AcademyException {
		
		Scarpa scarpa = new Scarpa();
		
		if (req.getId() != null) {
			Optional<Scarpa> optional = scarpaR.findById(req.getId());
			if(optional.isPresent()) {
				scarpa = optional.get();
			} else
                throw new AcademyException(msgS.getMessaggio("scarpa-ntexist"));
		} else
			scarpa = new Scarpa();
		
		if(req.getTagliaScarpe() == null)
			throw new AcademyException(msgS.getMessaggio("scarpa-taglia-null"));
		
		if(req.getChiusura() == null)
			throw new AcademyException(msgS.getMessaggio("scarpa-chiusura-null"));
		
		if(req.getTipoScarpa() == null)
			throw new AcademyException(msgS.getMessaggio("scarpa-tipo-null"));
		
		scarpa.setTagliaScarpe(req.getTagliaScarpe());
		
		Optional<Chiusura> chiusura = chiusuraR.findByDesc(req.getChiusura());
		if (chiusura.isEmpty())
			throw new AcademyException(msgS.getMessaggio("chiusura-ntexist"));
		scarpa.setChiusura(chiusura.get());
		
		Optional<TipoScarpa> tipoScarpa = tipoScarpaR.findByDesc(req.getTipoScarpa());
		if (tipoScarpa.isEmpty())
			throw new AcademyException(msgS.getMessaggio("tipo-scarpa-ntexist"));
		scarpa.setTipoScarpa(tipoScarpa.get());
		
		try {
			scarpaR.save(scarpa);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("scarpa-generic"));
		}

	}

	@Override
	public ScarpaDTO searchById(Integer id) throws AcademyException {
	Optional<Scarpa> optional = scarpaR.findById(id);
	
	if(optional.isEmpty())
        throw new AcademyException(msgS.getMessaggio("scarpa-ntexist"));

		return new ScarpaDTO(
				optional.get().getId(),
				optional.get().getTagliaScarpe(),
				optional.get().getChiusura().getDesc(),
				optional.get().getTipoScarpa().getDesc()
				);
	}

	@Override
	public List<ScarpaDTO> listAll() {
		return trasformInDTO(scarpaR.findAll());
	}

	private List<ScarpaDTO> trasformInDTO(List<Scarpa> resp) {
		return resp.stream()
				.map(k-> new ScarpaDTO(
						k.getId(),
						k.getTagliaScarpe(),
						k.getChiusura().getDesc(),
						k.getTipoScarpa().getDesc()
						)
					)
				.collect(Collectors.toList());
	}
	
	

				


}
