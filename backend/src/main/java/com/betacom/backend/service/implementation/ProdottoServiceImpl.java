package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.dto.CamiciaDTO;
import com.betacom.backend.dto.MagliettaDTO;
import com.betacom.backend.dto.PantaloneDTO;
import com.betacom.backend.dto.ProdottoDTO;
import com.betacom.backend.dto.ScarpaDTO;
import com.betacom.backend.dto.VestitoDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Camicia;
import com.betacom.backend.pojo.Colore;
import com.betacom.backend.pojo.Fantasia;
import com.betacom.backend.pojo.Maglietta;
import com.betacom.backend.pojo.Marca;
import com.betacom.backend.pojo.Materiale;
import com.betacom.backend.pojo.Pantalone;
import com.betacom.backend.pojo.Prodotto;
import com.betacom.backend.pojo.Scarpa;
import com.betacom.backend.pojo.Vestito;
import com.betacom.backend.repository.ICamiciaRepository;
import com.betacom.backend.repository.IColoreRepository;
import com.betacom.backend.repository.IFantasiaRepository;
import com.betacom.backend.repository.IMagliettaRepository;
import com.betacom.backend.repository.IMarcaRepository;
import com.betacom.backend.repository.IMaterialeRepository;
import com.betacom.backend.repository.IPantaloneRepository;
import com.betacom.backend.repository.IProdottoRepository;
import com.betacom.backend.repository.IScarpaRepository;
import com.betacom.backend.repository.IVestitoRepository;
import com.betacom.backend.request.ProdottoReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IProdottoService;
import com.betacom.backend.util.Sesso;

@Service
public class ProdottoServiceImpl implements IProdottoService {
	
	@Autowired
	IMessaggioService msgS;
	@Autowired
	IProdottoRepository prodottoR; 
	@Autowired
	IColoreRepository coloreR;
	@Autowired
	IMarcaRepository marcaR;
	@Autowired
	IMaterialeRepository materialeR;
	@Autowired
	IFantasiaRepository fantasiaR;
	@Autowired
	IMagliettaRepository magliettaR;
	@Autowired
	IPantaloneRepository pantaloneR;
	@Autowired
	IVestitoRepository vestitoR;
	@Autowired
	IScarpaRepository scarpaR;
	@Autowired
	ICamiciaRepository camiciaR;
	
	@Override
	public void create(ProdottoReq req) throws AcademyException {
		
		Prodotto prodotto = null;
		
		if(req.getId() != null) {
			Optional<Prodotto> optional = prodottoR.findById(req.getId());
			if (optional.isEmpty())
				throw new AcademyException(msgS.getMessaggio("prodotto-ntexist"));
			else 
				prodotto = optional.get();
		} else
			prodotto = new Prodotto();
		
		if(req.getQty() == null)
			throw new AcademyException(msgS.getMessaggio("prodotto-qty-null"));
		prodotto.setQty(req.getQty());
		
		if(req.getSesso()==null)
			throw new AcademyException(msgS.getMessaggio("prodotto-sesso-null"));
		prodotto.setSesso(Sesso.valueOf(req.getSesso()));
		
		if(req.getPrezzo()==null)
			throw new AcademyException(msgS.getMessaggio("prodotto-prezzo-null"));
		prodotto.setPrezzo(req.getPrezzo());
		
		if(req.getColore()==null)
			throw new AcademyException(msgS.getMessaggio("prodotto-colore-null"));
		Colore colore = coloreR.findByDesc(req.getColore())	
				.orElseThrow(()-> new AcademyException(msgS.getMessaggio("colore-ntexist"))); 
		prodotto.setColore(colore);
		
		if(req.getMarca()==null)
			throw new AcademyException(msgS.getMessaggio("prodotto-marca-null"));
		Marca marca = marcaR.findByDesc(req.getMarca())
				.orElseThrow(()-> new AcademyException(msgS.getMessaggio("marca-ntexist")));
		prodotto.setMarca(marca);
	
		if(req.getMateriale()==null)
			throw new AcademyException(msgS.getMessaggio("prodotto-materiale-null"));
		Materiale materiale = materialeR.findByDesc(req.getMateriale())
				.orElseThrow(()-> new AcademyException(msgS.getMessaggio("materiale-ntexist")));
		prodotto.setMateriale(materiale);
		
		if(req.getFantasia()==null)
			throw new AcademyException(msgS.getMessaggio("prodotto-fantasia-null"));
		Fantasia fantasia = fantasiaR.findByDesc(req.getFantasia())
				.orElseThrow(()-> new AcademyException(msgS.getMessaggio("fantasia-ntexist")));
		prodotto.setFantasia(fantasia);
		
		if (req.getMagliettaReq() != null) {
			Maglietta maglietta = magliettaR.findById(req.getMagliettaReq().getId())
					.orElseThrow(() -> new AcademyException(msgS.getMessaggio("maglietta-ntexist")));
			prodotto.setMaglietta(maglietta);
		} else
			prodotto.setMaglietta(null);

		if (req.getPantaloneReq() != null) {
			Pantalone pantalone = pantaloneR.findById(req.getPantaloneReq().getId())
					.orElseThrow(() -> new AcademyException(msgS.getMessaggio("pantalone-ntexist")));
			prodotto.setPantalone(pantalone);
		} else
			prodotto.setPantalone(null);
		
		if (req.getVestitoReq() != null) {
			Vestito vestito = vestitoR.findById(req.getVestitoReq().getId())
					.orElseThrow(() -> new AcademyException(msgS.getMessaggio("vestito-ntexist")));
			prodotto.setVestito(vestito);
		} else
			prodotto.setVestito(null);
		
		if (req.getScarpaReq() != null) {
			Scarpa scarpa = scarpaR.findById(req.getScarpaReq().getId())
					.orElseThrow(() -> new AcademyException(msgS.getMessaggio("scarpa-ntexist")));
			prodotto.setScarpa(scarpa);
		} else
			prodotto.setScarpa(null);
		
		if (req.getCamiciaReq() != null) {
			Camicia camicia = camiciaR.findById(req.getCamiciaReq().getId())
					.orElseThrow(() -> new AcademyException(msgS.getMessaggio("camicia-ntexist")));
			prodotto.setCamicia(camicia);
		} else
			prodotto.setCamicia(null);
	
	try {
		prodottoR.save(prodotto);
	} catch (Exception e) {
		throw new AcademyException(msgS.getMessaggio("prodotto-generic"));
	}
	}
	
	@Override
	public ProdottoDTO searchById(Integer id) throws AcademyException {
		Optional<Prodotto> optional = prodottoR.findById(id);
		if (optional.isEmpty())
			throw new AcademyException(msgS.getMessaggio("prodotto-ntexist"));
		
		Prodotto p = optional.get();

		return new ProdottoDTO(
				p.getId(),
				p.getQty(), 
				p.getSesso().toString(), 
				p.getColore().getDesc(),
				p.getMarca().getDesc(), 
				p.getMateriale().getDesc(), 
				p.getFantasia().getDesc(),
				p.getMaglietta() == null ? null : trasformMagliettaInDTO(p.getMaglietta()),
				p.getPantalone() == null ? null : trasformPantaloneInDTO(p.getPantalone()),
				p.getVestito() == null ? null : trasformVestitoInDTO(p.getVestito()),
				p.getScarpa() == null ? null : trasformScarpaInDTO(p.getScarpa()),
				p.getCamicia() == null ? null : trasformCamiciaInDTO(p.getCamicia()),
				p.getPrezzo());
	}

	@Override
	public List<ProdottoDTO> listAll() {
		return trasformInDTO(prodottoR.findAll());
	}

	public List<ProdottoDTO> trasformInDTO(List<Prodotto> resp) {
		
		return resp.stream()
				.map(k-> new ProdottoDTO(
					k.getId(),
					k.getQty(),
					k.getSesso().toString(),
					k.getColore().getDesc(),
					k.getMarca().getDesc(),
					k.getMateriale().getDesc(),
					k.getFantasia().getDesc(),
					k.getMaglietta() == null ? null : trasformMagliettaInDTO(k.getMaglietta()),
					k.getPantalone() == null ? null : trasformPantaloneInDTO(k.getPantalone()),
					k.getVestito() == null ? null : trasformVestitoInDTO(k.getVestito()),
					k.getScarpa() == null ? null : trasformScarpaInDTO(k.getScarpa()),
					k.getCamicia() == null ? null : trasformCamiciaInDTO(k.getCamicia()),
					k.getPrezzo()
					)).collect(Collectors.toList());
	}

	public CamiciaDTO trasformCamiciaInDTO(Camicia camicia) {
		return new CamiciaDTO(
				camicia.getId(),
				camicia.getTaglia().getDesc(),
				camicia.getVestibilita().getDesc(),
				camicia.getLunghezzaManica().getDesc(),
				camicia.getTipoColletto().getDesc()
				);
	}

	public ScarpaDTO trasformScarpaInDTO(Scarpa scarpa) {
		return new ScarpaDTO(
				scarpa.getId(),
				scarpa.getTagliaScarpe(),
				scarpa.getChiusura().getDesc(),
				scarpa.getTipoScarpa().getDesc());
	}

	public VestitoDTO trasformVestitoInDTO(Vestito vestito) {
		return new VestitoDTO(
				vestito.getId(),
				vestito.getTaglia().getDesc(),
				vestito.getVestibilita().getDesc(),
				vestito.getLunghezza().getDesc(),
				vestito.getLunghezzaManica().getDesc()
				);
	}

	public PantaloneDTO trasformPantaloneInDTO(Pantalone pantalone) {
		
		return new PantaloneDTO(
				pantalone.getId(),
				pantalone.getTaglia().getDesc(),
				pantalone.getVestibilita().getDesc(),
				pantalone.getLunghezza().getDesc());
	}

	public MagliettaDTO trasformMagliettaInDTO(Maglietta maglietta) {
		
		return new MagliettaDTO(
				maglietta.getId(),
				maglietta.getTaglia().getDesc(),
				maglietta.getVestibilita().getDesc(),
				maglietta.getLunghezzaManica().getDesc(),
				maglietta.getTipoColletto().getDesc()
				);
	}

	

}
