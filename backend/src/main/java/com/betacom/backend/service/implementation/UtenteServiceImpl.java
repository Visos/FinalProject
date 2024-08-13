package com.betacom.backend.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.dto.UtenteDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Utente;
import com.betacom.backend.repository.IUtenteRepository;
import com.betacom.backend.request.UtenteReq;
import com.betacom.backend.service.interfaces.IMessaggioService;
import com.betacom.backend.service.interfaces.IUtenteService;
import com.betacom.backend.util.Ruolo;

@Service
public class UtenteServiceImpl implements IUtenteService {

    @Autowired
    IUtenteRepository utenteR;

    @Autowired
    IMessaggioService msgS;

    @Override
    public void createOrUpdate(UtenteReq req) throws AcademyException {
        
        Utente utente = new Utente();
        
        if (req.getId()!= null) {
            Optional<Utente> optional = utenteR.findById(req.getId());
            if (optional.isPresent()) {
                utente = optional.get();
            } else {
                throw new AcademyException(msgS.getMessaggio("utente-ntexist"));
            }
        } else {
            utente = new Utente();
        }

        if (req.getNome() == null) 
            throw new AcademyException(msgS.getMessaggio("utente-nome-null"));
        
        if (req.getCognome() == null) 
            throw new AcademyException(msgS.getMessaggio("utente-cognome-null"));

        if (req.getMail() == null) 
            throw new AcademyException(msgS.getMessaggio("utente-mail-null"));
        
        if (req.getPassword() == null) 
            throw new AcademyException(msgS.getMessaggio("utente-password-null"));

        if (req.getRuolo() == null) 
            throw new AcademyException(msgS.getMessaggio("utente-ruolo-null"));

        utente.setNome(req.getNome());
        utente.setCognome(req.getCognome());
        utente.setMail(req.getMail());
        utente.setPassword(req.getPassword());
        utente.setRuolo(Ruolo.valueOf(req.getRuolo()));
        utente.setPaese(req.getPaese());
        utente.setStrada(req.getStrada());
        utente.setCivico(req.getCivico());
        utente.setCap(req.getCap());

        try {
            utenteR.save(utente);
        } catch (Exception e) {
            throw new AcademyException(msgS.getMessaggio("utente-generic") + e.getMessage());
        }
    }

    @Override
    public UtenteDTO searchById(Integer id) throws AcademyException {
        Optional<Utente> optional = utenteR.findById(id);
        if (optional.isEmpty())
            throw new AcademyException(msgS.getMessaggio("utente-ntexist"));
        
        return new UtenteDTO(
            optional.get().getId(),
            optional.get().getNome(),
            optional.get().getCognome(),
            optional.get().getMail(),
            optional.get().getPassword(),
            optional.get().getRuolo().name(),
            optional.get().getPaese(),
            optional.get().getStrada(),
            optional.get().getCivico(),
            optional.get().getCap()
        );
    }

    @Override
    public UtenteDTO searchByMail(String mail) throws AcademyException {
        
        Optional<Utente> optional = utenteR.findByMail(mail);
        if (optional.isEmpty())
            throw new AcademyException(msgS.getMessaggio("utente-no-mail"));
        
        return new UtenteDTO(
            optional.get().getId(),
            optional.get().getNome(),
            optional.get().getCognome(),
            optional.get().getMail(),
            optional.get().getPassword(),
            optional.get().getRuolo().name(),
            optional.get().getPaese(),
            optional.get().getStrada(),
            optional.get().getCivico(),
            optional.get().getCap()
        );
    }

    @Override
    public List<UtenteDTO> listAll() {
        return trasformInDTO(utenteR.findAll());
    }

    private List<UtenteDTO> trasformInDTO(List<Utente> resp){
		return resp.stream()
				.map(a -> new UtenteDTO(
                        a.getId(),
                        a.getNome(),
                        a.getCognome(),
                        a.getMail(),
                        a.getPassword(),
                        a.getRuolo().name(),
                        a.getPaese(),
                        a.getStrada(),
                        a.getCivico(),
                        a.getCap()
						)
					)
				.collect(Collectors.toList());
	}

}
