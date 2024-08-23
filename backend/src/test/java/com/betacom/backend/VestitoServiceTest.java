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
import com.betacom.backend.request.VestitoReq;
import com.betacom.backend.service.interfaces.IVestitoService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VestitoServiceTest {

	@Autowired
	IVestitoService vestitoS;

//	vestibilita: normal, Regular
//	taglia:L,S
// 	lunghezza: caviglia, lunga
//  lunghezzaManica: polso, corta
	
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

	@Test
	@Order(2)
	public void updateTest() {
		VestitoReq req = new VestitoReq();
		req.setId(1);
		req.setTaglia("S");
		req.setVestibilita("Regular");
		req.setLunghezza("Lunga");
		req.setLunghezzaManica("Corta");

		assertDoesNotThrow(() -> {
			vestitoS.createOrUpdate(req);
		});
	}

	@Test
	@Order(3)
	public void updateTestExceptionNotFound() {
		VestitoReq req = new VestitoReq();
		req.setId(100);
		req.setTaglia("L");
		req.setVestibilita("Regular");
		req.setLunghezza("Lunga");
		req.setLunghezzaManica("Corta");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("vestito-ntexist", exception.getMessage());
	}

	@Test
	@Order(4)
	public void createTestExceptionTagliaNotFound() {
		VestitoReq req = new VestitoReq();
		req.setTaglia("XS");
		req.setVestibilita("Regular");
		req.setLunghezza("Lunga");
		req.setLunghezzaManica("Corta");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("taglia-ntexist", exception.getMessage());
	}

	@Test
	@Order(5)
	public void createTestExceptionLunghezzaManicaNotFound() {
		VestitoReq req = new VestitoReq();
		req.setTaglia("S");
		req.setVestibilita("Regular");
		req.setLunghezza("Lunga");
		req.setLunghezzaManica("Senza Maniche");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("lunghezzaManica-ntexist", exception.getMessage());
	}

	@Test
	@Order(6)
	public void createTestExceptionVestibilitaNotFound() {
		VestitoReq req = new VestitoReq();
		req.setTaglia("S");
		req.setVestibilita("Ultra Slim");
		req.setLunghezza("Lunga");
		req.setLunghezzaManica("Corta");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("vestibilita-ntexist", exception.getMessage());
	}

	@Test
	@Order(7)
	public void searchByIdTest() {

		assertDoesNotThrow(() -> {
			vestitoS.searchById(1);
		});
	}

	@Test
	@Order(8)
	public void searchByIdTestException() {

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.searchById(100);
		});

		assertEquals("vestito-ntexist", exception.getMessage());
	}

	@Test
	@Order(9)
	public void listAllTest() {
		assertDoesNotThrow(() -> {
			vestitoS.listAll();
		});
	}
	
	@Test
	@Order(10)
	public void createTestExceptionTagliaNotNull() {
		VestitoReq req = new VestitoReq();
		req.setVestibilita("Regular");
		req.setLunghezza("Lunga");
		req.setLunghezzaManica("Corta");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("vestito-taglia-null", exception.getMessage());
	}
	
	@Test
	@Order(11)
	public void createTestExceptionVestibilitaNotNull() {
		VestitoReq req = new VestitoReq();
		req.setTaglia("S");
		req.setVestibilita(null);
		req.setLunghezza("Lunga");
		req.setLunghezzaManica("Corta");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("vestito-vestibilita-null", exception.getMessage());
	}
	
	@Test
	@Order(12)
	public void createTestExceptionLunghezzaNotNull() {
		VestitoReq req = new VestitoReq();
		req.setTaglia("S");
		req.setVestibilita("Regular");
		req.setLunghezza(null);
		req.setLunghezzaManica("Corta");

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("vestito-lunghezza-null", exception.getMessage());
	}
	
	@Test
	@Order(13)
	public void createTestExceptionLunghezzaManicaNotNull() {
		VestitoReq req = new VestitoReq();
		req.setTaglia("S");
		req.setVestibilita("Regular");
		req.setLunghezza("Lunga");
		req.setLunghezzaManica(null);

		AcademyException exception = assertThrows(AcademyException.class, () -> {
			vestitoS.createOrUpdate(req);
		});

		assertEquals("vestito-lunghezza-manica-null", exception.getMessage());
	}

}
