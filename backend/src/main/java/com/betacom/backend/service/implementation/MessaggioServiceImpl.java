package com.betacom.backend.service.implementation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betacom.backend.pojo.Messaggi;
import com.betacom.backend.repository.IMessaggioRepository;
import com.betacom.backend.service.interfaces.IMessaggioService;

@Service
public class MessaggioServiceImpl implements IMessaggioService{

	@Autowired
	IMessaggioRepository msgR;
	
	@Override
	public String getMessaggio(String code) {
		Optional<Messaggi> msg = msgR.findById(code);
		String res = null;
		if (msg.isEmpty())
			res = code;
		else
			res = msg.get().getMessaggio();

		return res;
	}
}
