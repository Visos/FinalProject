package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.dto.MagliettaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.LunghezzaManica;
import com.betacom.backend.pojo.Taglia;
import com.betacom.backend.pojo.Vestibilita;
import com.betacom.backend.pojo.Maglietta;
import com.betacom.backend.pojo.TipoColletto;
import com.betacom.backend.repository.ILunghezzaManicaRepository;
import com.betacom.backend.repository.ITagliaRepository;
import com.betacom.backend.repository.IVestibilitaRepository;
import com.betacom.backend.repository.IMagliettaRepository;
import com.betacom.backend.repository.ITipoCollettoRepository;
import com.betacom.backend.request.MagliettaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IMagliettaService;

@Service
public class MagliettaServiceImpl implements IMagliettaService {

    @Autowired
    IMessaggioService msgS;

    @Autowired
    IMagliettaRepository magliettaR;

    @Autowired
    ITagliaRepository tagliaR;

    @Autowired
    IVestibilitaRepository vestibilitaR;

    @Autowired
    ILunghezzaManicaRepository lunghezzaManicaR;

    @Autowired
    ITipoCollettoRepository tipoCollettoR;

    @Override
    public Maglietta createOrUpdate(MagliettaReq req) throws AcademyException {

        Maglietta maglietta = new Maglietta();

        if (req.getId() != null) {
            Optional<Maglietta> optional = magliettaR.findById(req.getId());
            if (optional.isPresent()) {
                maglietta = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("maglietta-ntexist"));
            }
        } else {
            maglietta = new Maglietta();
        }

        if (req.getTaglia() == null)
            throw new AcademyException(msgS.getMessaggio("maglietta-taglia-null"));

        if (req.getVestibilita() == null)
            throw new AcademyException(msgS.getMessaggio("maglietta-vestibilita-null"));

        if (req.getLunghezzaManica() == null)
            throw new AcademyException(msgS.getMessaggio("maglietta-lunghezza-manica-null"));

        if (req.getTipoColletto() == null)
            throw new AcademyException(msgS.getMessaggio("maglietta-tipo-colletto-null"));

        Optional<Taglia> taglia = tagliaR.findByDesc(req.getTaglia());
        if (taglia.isEmpty())
            throw new AcademyException(msgS.getMessaggio("taglia-ntexist"));
        maglietta.setTaglia(taglia.get());

        Optional<Vestibilita> vestibilita = vestibilitaR.findByDesc(req.getVestibilita());
        if (vestibilita.isEmpty())
            throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));
        maglietta.setVestibilita(vestibilita.get());

        Optional<LunghezzaManica> lunghezzaManica = lunghezzaManicaR.findByDesc(req.getLunghezzaManica());
        if (lunghezzaManica.isEmpty())
            throw new AcademyException(msgS.getMessaggio("lunghezzaManica-ntexist"));
        maglietta.setLunghezzaManica(lunghezzaManica.get());

        Optional<TipoColletto> tipoColletto = tipoCollettoR.findByDesc(req.getTipoColletto());
        if (tipoColletto.isEmpty())
            throw new AcademyException(msgS.getMessaggio("tipoColletto-ntexist"));
        maglietta.setTipoColletto(tipoColletto.get());

        try {
            magliettaR.save(maglietta);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("maglietta-generic"));
        }
        
        return maglietta;

    }

    @Override
    public MagliettaDTO searchById(Integer id) throws AcademyException {
        Optional<Maglietta> optional = magliettaR.findById(id);
        if (optional.isEmpty())
            throw new AcademyException(msgS.getMessaggio("maglietta-ntexist"));

        return new MagliettaDTO(
                optional.get().getId(),
                optional.get().getTaglia().getDesc(),
                optional.get().getVestibilita().getDesc(),
                optional.get().getLunghezzaManica().getDesc(),
                optional.get().getTipoColletto().getDesc()
        );
    }

    @Override
    public List<MagliettaDTO> listAll() {
        return trasformInDTO(magliettaR.findAll());
    }

    private List<MagliettaDTO> trasformInDTO(List<Maglietta> resp) {
        return resp.stream()
                .map(k -> new MagliettaDTO(
                        k.getId(),
                        k.getTaglia().getDesc(),
                        k.getVestibilita().getDesc(),
                        k.getLunghezzaManica().getDesc(),
                        k.getTipoColletto().getDesc()
                ))
                .collect(Collectors.toList());
    }
}
