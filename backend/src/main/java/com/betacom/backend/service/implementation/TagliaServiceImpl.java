package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Taglia;
import com.betacom.backend.repository.ITagliaRepository;
import com.betacom.backend.request.TagliaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.ITagliaService;

@Service
public class TagliaServiceImpl implements ITagliaService {
	
	@Autowired
	IMessaggioService msgS;

	@Autowired
	ITagliaRepository tagliaR;

	@Override 
	public void createOrUpdate(TagliaReq req) throws AcademyException {
		Taglia taglia = null; 
		
		if(req.getId()!=null) {
			Optional<Taglia> opt = tagliaR.findById(req.getId());
			if(opt.isPresent())
				taglia = opt.get();
			else 
				throw new AcademyException(msgS.getMessaggio("taglia-ntexist"));
		} else 
			taglia = new Taglia();
		
		if(req.getDescrizione()!=null) {
			List<Taglia> listTaglia = tagliaR.findAll();
			for (Taglia t:listTaglia) {
				if(req.getDescrizione().equalsIgnoreCase(t.getDesc()))
					throw new AcademyException(msgS.getMessaggio("taglia-exist"));
			}
		} else 
			throw new AcademyException(msgS.getMessaggio("taglia-desc-null"));

		
		taglia.setDesc(req.getDescrizione());
		
		try {
			tagliaR.save(taglia);
		} catch (Exception e) {
			throw new AcademyException(msgS.getMessaggio("taglia-generic" + e.getMessage()));
		}
		
	}

	@Override
	public TagliaReq searchById(Integer id) throws AcademyException {
		Optional<Taglia> opt = tagliaR.findById(id);
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("taglia-ntexist"));
		
		return new TagliaReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

	@Override
	public TagliaReq searchByDesc(String desc) throws AcademyException {
		Optional<Taglia> opt = tagliaR.findByDesc(desc);
		
		if (opt.isEmpty())
			throw new AcademyException(msgS.getMessaggio("taglia-ntexist"));
		
		return new TagliaReq(
				opt.get().getId(),
				opt.get().getDesc());
	}

	@Override
	public List<TagliaReq> listAll() {
	
		return trasformInReq(tagliaR.findAll());
	}
	
	private List<TagliaReq> trasformInReq(List<Taglia> resp) {
		return resp.stream()
				.map(a -> new TagliaReq(
						a.getId(),
                        a.getDesc()
						)
					)
				.collect(Collectors.toList());
	}

}
