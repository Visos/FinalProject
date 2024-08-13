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
import com.betacom.backend.request.TipoCollettoReq;
import com.betacom.backend.service.interfaces.ITipoCollettoService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TipoCollettoServiceImplTest {
	
	@Autowired
	ITipoCollettoService tipoCollettoS;

	@Test
	@Order(1)
	public void createTest() {
		TipoCollettoReq req = new TipoCollettoReq();
		req.setDescrizione("normale");
	
		assertDoesNotThrow(() -> {
			tipoCollettoS.createOrUpdate(req);
	        });
	}
	
	@Test
	@Order(2)
	public void updateTest() {
		TipoCollettoReq req = new TipoCollettoReq();
		req.setId(1);
		req.setDescrizione("coreana");
		assertDoesNotThrow(() -> {
			tipoCollettoS.createOrUpdate(req);
	        });
	}
	
	@Test
	@Order(3)
	public void updateTestExceptionNotFound() {
		TipoCollettoReq req = new TipoCollettoReq();
		req.setId(100);
		req.setDescrizione("coreana");
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoCollettoS.createOrUpdate(req);
        });
		
		assertEquals("tipoColletto-ntexist", exception.getMessage());
	}
	
	@Test
	@Order(4)
	public void createTestExceptionDuplicate() {
		TipoCollettoReq req = new TipoCollettoReq();
		req.setDescrizione("coreana");
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoCollettoS.createOrUpdate(req);
        });
		
		assertEquals("tipoColletto-exist", exception.getMessage());
	}
	
	@Test
	@Order(5)
	public void updateTestExceptionDuplicate() {
		TipoCollettoReq req = new TipoCollettoReq();
		req.setId(1);
		req.setDescrizione("coreana");
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoCollettoS.createOrUpdate(req);
        });
		
		assertEquals("tipoColletto-exist", exception.getMessage());
	}
	
	@Test
	@Order(6)
	public void createTestExceptionNoDesc() {
		TipoCollettoReq req = new TipoCollettoReq();
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoCollettoS.createOrUpdate(req);
        });
		
		assertEquals("tipoColletto-desc-null", exception.getMessage());
	}
	
	@Test
	@Order(7)
	public void updateTestExceptionNoDesc() {
		TipoCollettoReq req = new TipoCollettoReq();
		req.setId(1);
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoCollettoS.createOrUpdate(req);
        });
		
		assertEquals("tipoColletto-desc-null", exception.getMessage());
	}
	
	@Test
	@Order(8)
	public void searchByIdTest() {
		assertDoesNotThrow(() -> {
			tipoCollettoS.searchById(1);
	        });
	}
	
	@Test
	@Order(9)
	public void searchByDescTest() {
		assertDoesNotThrow(() -> {
			tipoCollettoS.searchByDesc("coreana");
	        });
	}
	
	@Test
	@Order(10)
	public void searchByIdTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoCollettoS.searchById(100);
        });
		
		assertEquals("tipoColletto-ntexist", exception.getMessage());
	}
	
	@Test
	@Order(11)
	public void searchByDescTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoCollettoS.searchByDesc("YOO");
        });
		
		assertEquals("tipoColletto-ntexist", exception.getMessage());
	}
}


