package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.dto.PantaloneDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Lunghezza;
import com.betacom.backend.pojo.Taglia;
import com.betacom.backend.pojo.Vestibilita;
import com.betacom.backend.pojo.Pantalone;
import com.betacom.backend.repository.ILunghezzaRepository;
import com.betacom.backend.repository.ITagliaRepository;
import com.betacom.backend.repository.IVestibilitaRepository;
import com.betacom.backend.repository.IPantaloneRepository;
import com.betacom.backend.request.PantaloneReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IPantaloneService;

@Service
public class PantaloneServiceImpl implements IPantaloneService {

    @Autowired
    IMessaggioService msgS;

    @Autowired
    IPantaloneRepository pantaloneR;

    @Autowired
    ITagliaRepository tagliaR;

    @Autowired
    IVestibilitaRepository vestibilitaR;

    @Autowired
    ILunghezzaRepository lunghezzaR;

    @Override
    public void createOrUpdate(PantaloneReq req) throws AcademyException {

        Pantalone pantalone = new Pantalone();

        if (req.getId() != null) {
            Optional<Pantalone> optional = pantaloneR.findById(req.getId());
            if (optional.isPresent()) {
                pantalone = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("pantalone-ntexist"));
            }
        } else {
            pantalone = new Pantalone();
        }

        if (req.getTaglia() == null)
            throw new AcademyException(msgS.getMessaggio("pantalone-taglia-null"));

        if (req.getVestibilita() == null)
            throw new AcademyException(msgS.getMessaggio("pantalone-vestibilita-null"));

        if (req.getLunghezza() == null)
            throw new AcademyException(msgS.getMessaggio("pantalone-lunghezza-null"));

        Optional<Taglia> taglia = tagliaR.findByDesc(req.getTaglia());
        if (taglia.isEmpty())
            throw new AcademyException(msgS.getMessaggio("taglia-ntexist"));
        pantalone.setTaglia(taglia.get());

        Optional<Vestibilita> vestibilita = vestibilitaR.findByDesc(req.getVestibilita());
        if (vestibilita.isEmpty())
            throw new AcademyException(msgS.getMessaggio("vestibilita-ntexist"));
        pantalone.setVestibilita(vestibilita.get());

        Optional<Lunghezza> lunghezza = lunghezzaR.findById(req.getLunghezza());
        if (lunghezza.isEmpty())
            throw new AcademyException(msgS.getMessaggio("lunghezza-ntexist"));
        pantalone.setLunghezza(lunghezza.get());

        try {
            pantaloneR.save(pantalone);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("pantalone-generic"));
        }

    }

    @Override
    public PantaloneDTO searchById(Integer id) throws AcademyException {
        Optional<Pantalone> optional = pantaloneR.findById(id);
        if (optional.isEmpty())
            throw new AcademyException(msgS.getMessaggio("pantalone-ntexist"));

        return new PantaloneDTO(
                optional.get().getId(),
                optional.get().getTaglia().getDesc(),
                optional.get().getVestibilita().getDesc(),
                optional.get().getLunghezza().getDesc()
        );
    }

    @Override
    public List<PantaloneDTO> listAll() {
        return trasformInDTO(pantaloneR.findAll());
    }

    private List<PantaloneDTO> trasformInDTO(List<Pantalone> resp) {
        return resp.stream()
                .map(k -> new PantaloneDTO(
                        k.getId(),
                        k.getTaglia().getDesc(),
                        k.getVestibilita().getDesc(),
                        k.getLunghezza().getDesc()
                ))
                .collect(Collectors.toList());
    }
}
