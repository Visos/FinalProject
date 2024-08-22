package com.betacom.backend;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.backend.request.ScarpaReq;
import com.betacom.backend.service.interfaces.IScarpaService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScarpaServiceTest {
	
	@Autowired
	IScarpaService scarpaS;
	
	@Test
	@Order(1)
	public void createTest() {
		ScarpaReq req = new ScarpaReq();
		req.setTagliaScarpe(39);
		req.setChiusura("chiuso");
		req.setTipoScarpa("Mocassini");
		
		assertDoesNotThrow(() -> {
			scarpaS.createOrUpdate(req);	
		});
	}
	

}
