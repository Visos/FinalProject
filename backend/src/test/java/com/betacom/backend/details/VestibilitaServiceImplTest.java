package com.betacom.backend.details;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.VestibilitaReq;
import com.betacom.backend.service.interfaces.IVestibilitaService;


@SpringBootTest
@RunWith(SpringRunner.class)
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
