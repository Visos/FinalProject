package com.betacom.backend;

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
import com.betacom.backend.request.ScarpaReq;
import com.betacom.backend.service.interfaces.IScarpaService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ScarpaServiceTest {
	
	@Autowired
	IScarpaService scarpaS;
	
	//chiusura: chiuso,semi-aperto
	//tipoScarpa: mocassini, Tacchi
	
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

	@Test
	@Order(2)
	public void updateTest() {
		ScarpaReq req = new ScarpaReq();
		req.setId(1);
		req.setTagliaScarpe(39);
		req.setChiusura("chiuso");
		req.setTipoScarpa("Tacchi");

		assertDoesNotThrow(() -> {
			scarpaS.createOrUpdate(req);
		});
	}

	@Test
	@Order(3)
	public void updateTestExceptionNotFound() {
		ScarpaReq req = new ScarpaReq();
		req.setId(100);
		req.setTagliaScarpe(39);
		req.setChiusura("semi-aperto");
		req.setTipoScarpa("Tacchi");


		AcademyException exception = assertThrows(AcademyException.class, () -> {
			scarpaS.createOrUpdate(req);
		});

		assertEquals("scarpa-ntexist", exception.getMessage());
	}

	@Test
	@Order(4)
	public void createTestExceptionChiusuraNotFound() {
		ScarpaReq req = new ScarpaReq();
		req.setTagliaScarpe(39);
		req.setChiusura("zip");
		req.setTipoScarpa("Mocassini");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			scarpaS.createOrUpdate(req);
		});

		assertEquals("chiusura-ntexist", exception.getMessage());
	}

	@Test
	@Order(6)
	public void createTestExceptionTipoScarpaNotFound() {
		ScarpaReq req = new ScarpaReq();
		req.setTagliaScarpe(39);
		req.setChiusura("chiuso");
		req.setTipoScarpa("infradito");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			scarpaS.createOrUpdate(req);
		});

		assertEquals("tipo-scarpa-ntexist", exception.getMessage());
	}

	@Test
	@Order(7)
	public void searchByIdTest() {

		assertDoesNotThrow(() -> {
			scarpaS.searchById(1);
		});
	}

	@Test
	@Order(8)
	public void searchByIdTestException() {

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			scarpaS.searchById(100);
		});

		assertEquals("scarpa-ntexist", exception.getMessage());
	}

	@Test
	@Order(9)
	public void listAllTest() {
		assertDoesNotThrow(() -> {
			scarpaS.listAll();
		});
	}
	
	@Test
	@Order(10)
	public void createTestExceptionTagliaScarpaNotNull() {
		ScarpaReq req = new ScarpaReq();
		req.setChiusura("chiuso");
		req.setTipoScarpa("Mocassini");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			scarpaS.createOrUpdate(req);
		});

		assertEquals("scarpa-taglia-null", exception.getMessage());
	}
	
	@Test
	@Order(11)
	public void createTestExceptionChiusuraNotNull() {
		ScarpaReq req = new ScarpaReq();
		req.setTagliaScarpe(39);
		req.setTipoScarpa("Mocassini");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			scarpaS.createOrUpdate(req);
		});

		assertEquals("scarpa-chiusura-null", exception.getMessage());
	}
	
	@Test
	@Order(12)
	public void createTestExceptionTipoScarpaNotNull() {
		ScarpaReq req = new ScarpaReq();
		req.setTagliaScarpe(39);
		req.setChiusura("chiuso");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			scarpaS.createOrUpdate(req);
		});

		assertEquals("scarpa-tipo-null", exception.getMessage());
	}

}
	


