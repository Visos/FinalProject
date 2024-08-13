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
import com.betacom.backend.request.TipoScarpaReq;
import com.betacom.backend.service.interfaces.ITipoScarpaService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TipoScarpaImplTest {
	
	@Autowired
	ITipoScarpaService tipoScarpaS;

	@Test
	@Order(1)
	public void createTest() {
		TipoScarpaReq req = new TipoScarpaReq();
		req.setDescrizione("Sneakers");
		
		assertDoesNotThrow(() -> {
			tipoScarpaS.createOrUpdate(req); 
			});
		}
	
	@Test
	@Order(2)
	public void updateTest() {
		TipoScarpaReq req = new TipoScarpaReq();
		req.setId(1);
		req.setDescrizione("Mocassini");
		
		assertDoesNotThrow(() -> {
			tipoScarpaS.createOrUpdate(req); 
			});
		}
	
	@Test
	@Order(3)
	public void updateTestExceptionNotFound() {
		TipoScarpaReq req = new TipoScarpaReq();
		req.setId(100);
		req.setDescrizione("Mocassini");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoScarpaS.createOrUpdate(req);
		 });
		
		assertEquals("tipoScarpa-ntexist", exception.getMessage());
	}
	
	@Test
	@Order(4)
	public void createTestExceptionDuplicate() {
		TipoScarpaReq req = new TipoScarpaReq();
		req.setDescrizione("Mocassini");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoScarpaS.createOrUpdate(req);
		 });
		
		assertEquals("tipoScarpa-exist", exception.getMessage());
	}
	
	@Test
	@Order(5)
	public void updateTestExceptionDuplicate() {
		TipoScarpaReq req = new TipoScarpaReq();
		req.setId(1);
		req.setDescrizione("Mocassini");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoScarpaS.createOrUpdate(req);
		 });
		
		assertEquals("tipoScarpa-exist", exception.getMessage());
	}
	@Test
	@Order(6)
	public void createTestExceptionNoDesc() {
		TipoScarpaReq req = new TipoScarpaReq();
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoScarpaS.createOrUpdate(req);
		 });
		
		assertEquals("tipoScarpa-desc-null", exception.getMessage());
	}
	
	@Test
	@Order(7)
	public void updateTestExceptionNoDesc() {
		TipoScarpaReq req = new TipoScarpaReq();
		req.setId(1);
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoScarpaS.createOrUpdate(req);
		 });
		
		assertEquals("tipoScarpa-desc-null", exception.getMessage());
	}
	
	@Test
	@Order(8)
	public void searchByIdTest() {
		assertDoesNotThrow(() -> {
			tipoScarpaS.searchById(1);
		});
	}
	
	@Test
	@Order(9)
	public void searchByDescTest() {
		assertDoesNotThrow(() -> {
			tipoScarpaS.searchByDesc("Mocassini");
			});
		}
	
	@Test
	@Order(10)
	public void searchByIdTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoScarpaS.searchById(100);
		});
		
		assertEquals("tipoScarpa-ntexist", exception.getMessage());

	}
	
	@Test
	@Order(11)
	public void searchByDescTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tipoScarpaS.searchByDesc("Stivali");
		});
		
		assertEquals("tipoScarpa-ntexist", exception.getMessage());
	}
}


