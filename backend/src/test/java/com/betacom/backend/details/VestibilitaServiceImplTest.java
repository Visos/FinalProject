package com.betacom.backend.details;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.backend.exception.AcademyException;
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
		req.setDescrizione("Slim");
	
		assertDoesNotThrow(() -> {
			vestibilitaS.createOrUpdate(req);
	        });
		
		req.setDescrizione("Regular");
		
		assertDoesNotThrow(() -> {
			vestibilitaS.createOrUpdate(req);
	        });
	}
	
	@Test
	@Order(2)
	public void updateTest() {
		VestibilitaReq req = new VestibilitaReq();
		req.setId(1);
		req.setDescrizione("Normal");
	
		assertDoesNotThrow(() -> {
			vestibilitaS.createOrUpdate(req);
	        });
	}
	
	@Test
	@Order(3)
	public void updateTestExceptionNotFound() {
		VestibilitaReq req = new VestibilitaReq();
		req.setId(100);
		req.setDescrizione("Normal");
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestibilitaS.createOrUpdate(req);
        });
		
		assertEquals("vestibilita-ntexist", exception.getMessage());
	}
	
	@Test
	@Order(4)
	public void createTestExceptionDuplicate() {
		VestibilitaReq req = new VestibilitaReq();
		req.setDescrizione("Normal");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestibilitaS.createOrUpdate(req);
        });
		
		assertEquals("vestibilita-exist", exception.getMessage());
	}
	
	@Test
	@Order(5)
	public void updateTestExceptionDuplicate() {
		VestibilitaReq req = new VestibilitaReq();
		req.setId(1);
		req.setDescrizione("Normal");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestibilitaS.createOrUpdate(req);
        });
		
		assertEquals("vestibilita-exist", exception.getMessage());
		
	}
	
	@Test
	@Order(6)
	public void createTestExceptionNoDesc() {
		VestibilitaReq req = new VestibilitaReq();
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestibilitaS.createOrUpdate(req);
        });
		
		assertEquals("vestibilita-desc-null", exception.getMessage());
		
	}
	
	@Test
	@Order(7)
	public void updateTestExceptionNoDesc() {
		VestibilitaReq req = new VestibilitaReq();
		req.setId(1);
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestibilitaS.createOrUpdate(req);
        });
		
		assertEquals("vestibilita-desc-null", exception.getMessage());
		
	}
	
	@Test
	@Order(8)
	public void searchByIdTest() {
		assertDoesNotThrow(() -> {
			vestibilitaS.searchById(1);
			});
		}
	
	@Test
	@Order(9)
	public void searchByDescTest() {
		assertDoesNotThrow(() -> {
			vestibilitaS.searchByDesc("Normal");
		});
	}
	
	@Test
	@Order(10)
	public void searchByIdTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestibilitaS.searchById(100);}
		);
		
		assertEquals("vestibilita-ntexist", exception.getMessage());
	}
	
	@Test
	@Order(11)
	public void searchByDescTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestibilitaS.searchByDesc("Yooo");}
		);
		
		assertEquals("vestibilita-ntexist", exception.getMessage());
	}


}
