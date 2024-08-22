package com.betacom.backend;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.backend.request.VestitoReq;
import com.betacom.backend.service.interfaces.IVestitoService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VestitoServiceTest {
	
	@Autowired
	IVestitoService vestitoS;
	
	@Test
	@Order(1)
	public void createTest() {
		VestitoReq req = new VestitoReq();
		req.setTaglia("L");
		req.setVestibilita("Normal");
		req.setLunghezza("caviglia");
		req.setLunghezzaManica("polso");
		
		assertDoesNotThrow(() -> {
			vestitoS.createOrUpdate(req);	
		});
	}

}
