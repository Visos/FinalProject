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
import com.betacom.backend.request.TagliaReq;
import com.betacom.backend.service.interfaces.ITagliaService;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TagliaServiceImplTest {
	
	@Autowired
	ITagliaService tagliaS;
	
	@Test
	@Order(1)
	public void createTest() {
		TagliaReq req = new TagliaReq();
		req.setDescrizione("M");
	
		assertDoesNotThrow(() -> {
			 tagliaS.createOrUpdate(req);
	        });
	}
	
	@Test
	@Order(2)
	public void updateTest() {
		TagliaReq req = new TagliaReq();
		req.setId(1);
		req.setDescrizione("L");
		assertDoesNotThrow(() -> {
			 tagliaS.createOrUpdate(req);
	        });
	}
	
	@Test
	@Order(3)
	public void updateTestExceptionNotFound() {
		TagliaReq req = new TagliaReq();
		req.setId(100);
		req.setDescrizione("L");
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tagliaS.createOrUpdate(req);
        });
		
		assertEquals("taglia-ntexist", exception.getMessage());
	}
	
	@Test
	@Order(4)
	public void createTestExceptionDuplicate() {
		TagliaReq req = new TagliaReq();
		req.setDescrizione("L");
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tagliaS.createOrUpdate(req);
        });
		
		assertEquals("taglia-exist", exception.getMessage());
	}
	
	@Test
	@Order(5)
	public void updateTestExceptionDuplicate() {
		TagliaReq req = new TagliaReq();
		req.setId(1);
		req.setDescrizione("L");
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tagliaS.createOrUpdate(req);
        });
		
		assertEquals("taglia-exist", exception.getMessage());
	}
	
	@Test
	@Order(6)
	public void createTestExceptionNoDesc() {
		TagliaReq req = new TagliaReq();
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tagliaS.createOrUpdate(req);
        });
		
		assertEquals("taglia-desc-null", exception.getMessage());
	}
	
	@Test
	@Order(7)
	public void updateTestExceptionNoDesc() {
		TagliaReq req = new TagliaReq();
		req.setId(1);
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tagliaS.createOrUpdate(req);
        });
		
		assertEquals("taglia-desc-null", exception.getMessage());
	}
	
	@Test
	@Order(8)
	public void searchByIdTest() {
		assertDoesNotThrow(() -> {
			 tagliaS.searchById(1);
	        });
	}
	
	@Test
	@Order(9)
	public void searchByDescTest() {
		assertDoesNotThrow(() -> {
			 tagliaS.searchByDesc("L");
	        });
	}
	
	@Test
	@Order(10)
	public void searchByIdTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tagliaS.searchById(100);
        });
		
		assertEquals("taglia-ntexist", exception.getMessage());
	}
	
	@Test
	@Order(11)
	public void searchByDescTestException() {
		AcademyException exception = assertThrows(AcademyException.class, () -> {
			tagliaS.searchByDesc("YOO");
        });
		
		assertEquals("taglia-ntexist", exception.getMessage());
	}
}
