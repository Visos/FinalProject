package com.betacom.backend.details;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.backend.request.VestibilitaReq;
import com.betacom.backend.service.interfaces.IVestibilitaService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VestibilitaServiceImplTest {
	
	@Autowired
	IVestibilitaService vestibilitaS;
	
	@Test
	@Order(1)
	public void createTest() {
		VestibilitaReq req = new VestibilitaReq();
		req.setDescrizione("alto");
	
		assertDoesNotThrow(() -> {
			vestibilitaS.createOrUpdate(req);
	        });
	}
	
	@Test
	@Order(2)
	public void updateTest() {
		VestibilitaReq req = new VestibilitaReq();
		req.setId(1);
		req.setDescrizione("corto");
	
		assertDoesNotThrow(() -> {
			vestibilitaS.createOrUpdate(req);
	        });
	}

}
