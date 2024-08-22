package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.dto.CamiciaDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.LunghezzaManica;
import com.betacom.backend.pojo.Taglia;
import com.betacom.backend.pojo.TipoColletto;
import com.betacom.backend.pojo.Vestibilita;
import com.betacom.backend.pojo.Camicia;
import com.betacom.backend.repository.ILunghezzaManicaRepository;
import com.betacom.backend.repository.ITagliaRepository;
import com.betacom.backend.repository.IVestibilitaRepository;
import com.betacom.backend.repository.ICamiciaRepository;
import com.betacom.backend.repository.ITipoCollettoRepository;
import com.betacom.backend.request.CamiciaReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.ICamiciaService;

@Service
public class CamiciaServiceImpl implements ICamiciaService {

    @Autowired
    IMessaggioService msgS;

    @Autowired
    ICamiciaRepository camiciaR;

    @Autowired
    ITagliaRepository tagliaR;

    @Autowired
    IVestibilitaRepository vestibilitaR;

    @Autowired
    ILunghezzaManicaRepository lunghezzaManicaR;

    @Autowired
    ITipoCollettoRepository tipoCollettoR;

    @Override
    public void createOrUpdate(CamiciaReq req) throws AcademyException {

        Camicia camicia = new Camicia();

        if (req.getId() != null) {
            Optional<Camicia> optional = camiciaR.findById(req.getId());
            if (optional.isPresent()) {
                camicia = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("camicia-ntexist"));
            }
        } else {
            camicia = new Camicia();
        }

        if (req.getTaglia() == null)
            throw new AcademyException(msgS.getMessaggio("camicia-taglia-null"));

        if (req.getVestibilita() == null)
            throw new AcademyException(msgS.getMessaggio("camicia-vestibilita-null"));

        if (req.getLunghezzaManica() == null)
            throw new AcademyException(msgS.getMessaggio("camicia-lunghezza-manica-null"));

        if (req.getTipoColletto() == null)
            throw new AcademyException(msgS.getMessaggio("camicia-tipo-colletto-null"));

        Optional<Taglia> taglia = tagliaR.findByDesc(req.getTaglia());
        if (taglia.isEmpty())
            throw new AcademyException(msgS.getMessaggio("taglia-ntexist"));
        camicia.setTaglia(taglia.get());

        Optional<Vestibilita> vestibilita = vestibilitaR.findByDesc(req.getVestibilita());
        if (vestibilita.isEmpty())
            throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));
        camicia.setVestibilita(vestibilita.get());

        Optional<LunghezzaManica> lunghezzaManica = lunghezzaManicaR.findById(req.getLunghezzaManica());
        if (lunghezzaManica.isEmpty())
            throw new AcademyException(msgS.getMessaggio("lunghezzaManica-ntexist"));
        camicia.setLunghezzaManica(lunghezzaManica.get());

        Optional<TipoColletto> tipoColletto = tipoCollettoR.findByDesc(req.getTipoColletto());
        if (tipoColletto.isEmpty())
            throw new AcademyException(msgS.getMessaggio("tipoColletto-ntexist"));
        camicia.setTipoColletto(tipoColletto.get());

        try {
            camiciaR.save(camicia);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("camicia-generic"));
        }

    }

    @Override
    public CamiciaDTO searchById(Integer id) throws AcademyException {
        Optional<Camicia> optional = camiciaR.findById(id);
        if (optional.isEmpty())
            throw new AcademyException(msgS.getMessaggio("camicia-ntexist"));

        return new CamiciaDTO(
                optional.get().getId(),
                optional.get().getTaglia().getDesc(),
                optional.get().getVestibilita().getDesc(),
                optional.get().getLunghezzaManica().getDesc(),
                optional.get().getTipoColletto().getDesc()
        );
    }

    @Override
    public List<CamiciaDTO> listAll() {
        return trasformInDTO(camiciaR.findAll());
    }

    private List<CamiciaDTO> trasformInDTO(List<Camicia> resp) {
        return resp.stream()
                .map(k -> new CamiciaDTO(
                        k.getId(),
                        k.getTaglia().getDesc(),
                        k.getVestibilita().getDesc(),
                        k.getLunghezzaManica().getDesc(),
                        k.getTipoColletto().getDesc()
                ))
                .collect(Collectors.toList());
    }
}
