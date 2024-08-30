package com.betacom.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Prodotto;
import com.betacom.backend.repository.IProdottoRepository;
import com.betacom.backend.request.PantaloneReq;
import com.betacom.backend.request.ProdottoReq;
import com.betacom.backend.service.interfaces.IProdottoService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdottoServiceTest {
	
	@Autowired
	IProdottoService prodottoS;
	
	@Autowired
	IProdottoRepository prodottoR;
	
	@Test
	@Order(1)
	void createProdotto() {
		ProdottoReq p = new ProdottoReq();
		p.setQty(1);
		p.setColore("rosso");
		p.setFantasia("");
		p.setImg("aaa");
		p.setMarca("Adidas");
		p.setMateriale("Lino");
		p.setPrezzo(5.0);
		p.setSesso("UOMO");
		p.setPantaloneReq(new PantaloneReq(1, "s", "aderente", "Normale" ));
		
		try {
			prodottoS.create(p);
		} catch (AcademyException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void findProdotto() {
	
		List<Prodotto> l = new ArrayList<Prodotto>();
		
		l = prodottoR.findAll();
		
		assertEquals(l.size(), 1);	
	
	}

}
