package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.dto.VestitoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Lunghezza;
import com.betacom.backend.pojo.LunghezzaManica;
import com.betacom.backend.pojo.Taglia;
import com.betacom.backend.pojo.Vestibilita;
import com.betacom.backend.pojo.Vestito;
import com.betacom.backend.repository.ILunghezzaManicaRepository;
import com.betacom.backend.repository.ILunghezzaRepository;
import com.betacom.backend.repository.ITagliaRepository;
import com.betacom.backend.repository.IVestibilitaRepository;
import com.betacom.backend.repository.IVestitoRepository;
import com.betacom.backend.request.VestitoReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IVestitoService;

@Service
public class VestitoServiceImpl implements IVestitoService {
	
	@Autowired
	IMessaggioService msgS;
	
	@Autowired
	IVestitoRepository vestitoR;
	
	@Autowired
	ILunghezzaRepository lunghezzaR;
	
	@Autowired
	ITagliaRepository tagliaR;
	
	@Autowired
	ILunghezzaManicaRepository lunghezzaManicaR;
	
	@Autowired
	IVestibilitaRepository vestibilitaR;

	@Override
	public Vestito createOrUpdate(VestitoReq req) throws AcademyException {
		
		Vestito vestito = new Vestito();
		 
		if (req.getId()!= null) {
	            Optional<Vestito> optional = vestitoR.findById(req.getId());
	            if (optional.isPresent()) {
	            	vestito = optional.get();
	            } else {
	                throw new AcademyException(msgS.getMessaggio("vestito-ntexist"));
	            }
	        } else {
	        	vestito = new Vestito();
	        }
		
		if (req.getTaglia() == null)
			throw new AcademyException(msgS.getMessaggio("vestito-taglia-null"));
		
		if (req.getVestibilita() == null)
			throw new AcademyException(msgS.getMessaggio("vestito-vestibilita-null"));
		
		if (req.getLunghezza() == null)
			throw new AcademyException(msgS.getMessaggio("vestito-lunghezza-null"));
	
		if (req.getLunghezzaManica() == null)
			throw new AcademyException(msgS.getMessaggio("vestito-lunghezza-manica-null"));
	
		Optional<Lunghezza> lunghezza = lunghezzaR.findByDesc(req.getLunghezza());
		if (lunghezza.isEmpty())
			throw new AcademyException(msgS.getMessaggio("lunghezza-ntexist"));
		vestito.setLunghezza(lunghezza.get());
		
		Optional<Taglia> taglia = tagliaR.findByDesc(req.getTaglia());
		if (taglia.isEmpty())
			throw new AcademyException(msgS.getMessaggio("taglia-ntexist"));
		vestito.setTaglia(taglia.get());
		
		Optional<Vestibilita> vestibilita = vestibilitaR.findByDesc(req.getVestibilita());
		if (vestibilita.isEmpty())
			throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));
		vestito.setVestibilita(vestibilita.get());
		
		Optional<LunghezzaManica> lunghezzaManica = lunghezzaManicaR.findByDesc(req.getLunghezzaManica());
		if (lunghezzaManica.isEmpty())
			throw new AcademyException(msgS.getMessaggio("lunghezzaManica-ntexist"));
		vestito.setLunghezzaManica(lunghezzaManica.get());
		
		try {
			vestitoR.save(vestito);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("vestito-generic"));
		}
		
		return vestito;
		
	}

	@Override
	public VestitoDTO searchById(Integer id) throws AcademyException {
		Optional<Vestito> optional = vestitoR.findById(id);
		if (optional.isEmpty())
			throw new AcademyException(msgS.getMessaggio("vestito-ntexist"));
		
		return new VestitoDTO(
				optional.get().getId(),
				optional.get().getTaglia().getDesc(),
				optional.get().getVestibilita().getDesc(),
				optional.get().getLunghezza().getDesc(),
				optional.get().getLunghezzaManica().getDesc()
				);
	}

	@Override
	public List<VestitoDTO> listAll() {
		return trasformInDTO(vestitoR.findAll());
	}
	
	private List<VestitoDTO> trasformInDTO(List<Vestito> resp){
		return resp.stream()
				.map(k -> new VestitoDTO(
						k.getId(),
						k.getTaglia().getDesc(),
						k.getVestibilita().getDesc(),
						k.getLunghezza().getDesc(),
						k.getLunghezzaManica().getDesc()
						)
					)
				.collect(Collectors.toList());
		
	}
	
	

	

}
