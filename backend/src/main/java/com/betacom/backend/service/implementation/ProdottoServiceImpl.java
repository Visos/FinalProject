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
import com.betacom.backend.service.interfaces.ICamiciaService;
import com.betacom.backend.service.interfaces.IMagliettaService;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IPantaloneService;
import com.betacom.backend.service.interfaces.IProdottoService;
import com.betacom.backend.service.interfaces.IScarpaService;
import com.betacom.backend.service.interfaces.IVestitoService;
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
	
	@Autowired
	IPantaloneService pantaloneS;
	
	@Autowired
	IMagliettaService magliettaS;
	
	@Autowired
	ICamiciaService camiciaS;
	
	@Autowired
	IScarpaService scarpaS;
	
	@Autowired
	IVestitoService vestitoS;
	
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
		
		if(req.getImg()==null)
			throw new AcademyException(msgS.getMessaggio("prodotto-img-null"));
		prodotto.setImg(req.getImg());
		
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
		    Optional<Maglietta> maglietta = null;
		    if(req.getMagliettaReq().getId() != null) {
		        maglietta = magliettaR.findById(req.getMagliettaReq().getId());
		        if(maglietta.isEmpty()) {
		            throw new AcademyException(msgS.getMessaggio("maglietta-ntexist"));
		        }
		    } else {
		        prodotto.setMaglietta(magliettaS.createOrUpdate(req.getMagliettaReq()));
		    }

		} else
		    prodotto.setMaglietta(null);

		
		
		if (req.getPantaloneReq() != null) {
			Optional<Pantalone> pantalone = null;
			if(req.getPantaloneReq().getId() != null) {
				pantalone = pantaloneR.findById(req.getPantaloneReq().getId());
				if(pantalone.isEmpty()) {
					throw new AcademyException(msgS.getMessaggio("pantalone-ntexist"));
				}
			}else {
				prodotto.setPantalone(pantaloneS.createOrUpdate(req.getPantaloneReq()));
			}

		} else
			prodotto.setPantalone(null);
		
		
		
		
		
		if (req.getVestitoReq() != null) {
		    Optional<Vestito> vestito = null;
		    if(req.getVestitoReq().getId() != null) {
		        vestito = vestitoR.findById(req.getVestitoReq().getId());
		        if(vestito.isEmpty()) {
		            throw new AcademyException(msgS.getMessaggio("vestito-ntexist"));
		        }
		    } else {
		        prodotto.setVestito(vestitoS.createOrUpdate(req.getVestitoReq()));
		    }

		} else
		    prodotto.setVestito(null);

		
		if (req.getScarpaReq() != null) {
		    Optional<Scarpa> scarpa = null;
		    if(req.getScarpaReq().getId() != null) {
		        scarpa = scarpaR.findById(req.getScarpaReq().getId());
		        if(scarpa.isEmpty()) {
		            throw new AcademyException(msgS.getMessaggio("scarpa-ntexist"));
		        }
		    } else {
		        prodotto.setScarpa(scarpaS.createOrUpdate(req.getScarpaReq()));
		    }

		} else
		    prodotto.setScarpa(null);

		
		if (req.getCamiciaReq() != null) {
		    Optional<Camicia> camicia = null;
		    if(req.getCamiciaReq().getId() != null) {
		        camicia = camiciaR.findById(req.getCamiciaReq().getId());
		        if(camicia.isEmpty()) {
		            throw new AcademyException(msgS.getMessaggio("camicia-ntexist"));
		        }
		    } else {
		        prodotto.setCamicia(camiciaS.createOrUpdate(req.getCamiciaReq()));
		    }

		} else
		    prodotto.setCamicia(null);

	
	try {
		prodottoR.save(prodotto);
	} catch (Exception e) {
		throw new AcademyException(msgS.getMessaggio("prodotto-generic") + e.getMessage());
		}
	System.out.println(req.getPantaloneReq());

	System.out.println(prodotto.getPantalone());
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
				p.getImg(),
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
	
	@Override
	public List<ProdottoDTO> listByParam(ProdottoReq req){
		Integer idMaglietta = null;
		Integer idPantalone= null;
		Integer idVestito= null;
		Integer idScarpa= null;
		Integer idCamicia= null;
		
		checkTipoReq(req, idMaglietta, idPantalone, idVestito, idScarpa, idCamicia);
		
		return trasformInDTO(prodottoR.findByParam(req.getId(), req.getSesso(), req.getColore(), req.getMarca(), req.getMateriale(), req.getFantasia(), idMaglietta, idPantalone, idVestito, idScarpa, idCamicia, req.getPrezzo()));
	}
	

	
	@Override
	public List<ProdottoDTO> findMaglietteByParam(ProdottoReq req){
		Integer idMaglietta= null;
		String taglia = null;
		String vestibilita = null;
		String colletto =null ;
		String lunghezzaManica = null;
		
		if(req.getMagliettaReq()!=null) {
			idMaglietta = req.getMagliettaReq().getId();
			taglia = req.getMagliettaReq().getTaglia();
			vestibilita = req.getMagliettaReq().getVestibilita();
			lunghezzaManica = req.getMagliettaReq().getLunghezzaManica();
		}
			
		return trasformInDTO(prodottoR.findMagliettaByParam(req.getId(), req.getSesso(), req.getColore(), req.getMarca(), req.getMateriale(), req.getFantasia(), idMaglietta, req.getPrezzo(), taglia, vestibilita, lunghezzaManica, colletto));
	}
	
	@Override
	public List<ProdottoDTO> findPantaloneByParam(ProdottoReq req){
		
		Integer idPantalone = null;
		String lunghezza = null;
		String taglia = null;
		String vestibilita = null;

		
		if(req.getPantaloneReq()!=null) {
			idPantalone = req.getPantaloneReq().getId();
			lunghezza = req.getPantaloneReq().getLunghezza();
			taglia = req.getPantaloneReq().getTaglia();
			vestibilita = req.getPantaloneReq().getVestibilita();
		}
			
		return trasformInDTO(prodottoR.findPantaloneByParam(req.getId(), req.getSesso(), req.getColore(), req.getMarca(), req.getMateriale(), req.getFantasia(), idPantalone, req.getPrezzo(), taglia, vestibilita, lunghezza));
	}
	
	@Override
	public List<ProdottoDTO> findVestitoByParam(ProdottoReq req){
			
		return trasformInDTO(prodottoR.findVestitoByParam(req.getId(), req.getSesso(), req.getColore(), req.getMarca(), req.getMateriale(), req.getFantasia(), req.getVestitoReq().getId(), req.getPrezzo(), req.getVestitoReq().getTaglia(), req.getVestitoReq().getVestibilita(), req.getVestitoReq().getLunghezza(), req.getVestitoReq().getLunghezzaManica()));
	}
	
	@Override
	public List<ProdottoDTO> findScarpaByParam(ProdottoReq req){
		Integer idScarpa = null;
		Integer tagliaScarpe = null;
		String chiusura = null;
		String tipoScarpa = null;

		
		if(req.getScarpaReq()!=null) {
			idScarpa = req.getScarpaReq().getId();
			tagliaScarpe = req.getScarpaReq().getTagliaScarpe();
			chiusura = req.getScarpaReq().getChiusura();
			tipoScarpa = req.getScarpaReq().getTipoScarpa();
		}
		
			
		return trasformInDTO(prodottoR.findScarpaByParam(req.getId(), req.getSesso(), req.getColore(), req.getMarca(), req.getMateriale(), req.getFantasia(), idScarpa, req.getPrezzo(), tagliaScarpe, chiusura, tipoScarpa ));
	}
	
	@Override
	public List<ProdottoDTO> findCamiciaByParam(ProdottoReq req){
		Integer idCamicia= null;
		String taglia = null;
		String vestibilita = null;
		String colletto =null ;
		String lunghezzaManica = null;
		
		if(req.getCamiciaReq()!=null) {
			idCamicia = req.getCamiciaReq().getId();
			taglia = req.getCamiciaReq().getTaglia();
			vestibilita = req.getCamiciaReq().getVestibilita();
			lunghezzaManica = req.getCamiciaReq().getLunghezzaManica();
		}
		
		return trasformInDTO(prodottoR.findCamiciaByParam(req.getId(), req.getSesso(), req.getColore(), req.getMarca(), req.getMateriale(), req.getFantasia(), idCamicia, req.getPrezzo(), taglia, vestibilita, lunghezzaManica, colletto));
	}
	
	public void checkTipoReq( ProdottoReq req, Integer idMaglietta, Integer idPantalone, Integer idVestito, Integer idScarpa, Integer idCamicia) {
		if(req.getCamiciaReq() !=null && req.getCamiciaReq().getId() != null) {
			idCamicia = req.getCamiciaReq().getId();
		}
		if(req.getPantaloneReq() !=null && req.getPantaloneReq().getId() != null) {
			idPantalone = req.getPantaloneReq().getId();
		}
		if(req.getVestitoReq() !=null && req.getVestitoReq().getId() != null) {
			idVestito = req.getVestitoReq().getId();
		}
		if(req.getScarpaReq() !=null && req.getScarpaReq().getId() != null) {
			idScarpa = req.getScarpaReq().getId();
		}
		if(req.getMagliettaReq() !=null && req.getMagliettaReq().getId() != null) {
			idMaglietta = req.getMagliettaReq().getId();
		}
	}

	@Override
	public List<ProdottoDTO> trasformInDTO(List<Prodotto> resp) {
		
		return resp.stream()
				.map(k-> new ProdottoDTO(
					k.getId(),
					k.getQty(),
					k.getSesso().toString(),
					k.getImg(),
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

	@Override
    public Prodotto getProdotto(Integer id) throws AcademyException {
       
        Optional<Prodotto> optional = prodottoR.findById(id);
        
        if (optional.isEmpty()) {
            throw new AcademyException(msgS.getMessaggio("prodotto-ntexist"));
        } else
            return optional.get();
    }


	

}
