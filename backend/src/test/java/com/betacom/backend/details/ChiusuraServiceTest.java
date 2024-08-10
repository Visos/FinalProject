package com.betacom.backend.details;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.pojo.Chiusura;
import com.betacom.backend.repository.IChiusuraRepository;
import com.betacom.backend.request.ChiusuraReq;
import com.betacom.backend.service.interfaces.IChiusuraService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChiusuraServiceTest {
	
	@Autowired
	IChiusuraRepository repoC;
	
	@Autowired
	IChiusuraService chiusuraS;
	
	@Test
	@Order(1)
	public void saveChiusura() {
		ChiusuraReq c = new ChiusuraReq();
		
		c.setDescrizione("aperto");
				
		assertDoesNotThrow(() -> {
            chiusuraS.createOrUpdate(c);
        });
		
		c.setDescrizione("chiuso");
		
		assertDoesNotThrow(() -> {
            chiusuraS.createOrUpdate(c);
        });
		
	}
	
	@Test
	@Order(2)
	public void saveChiusuraNull() {
		ChiusuraReq c = new ChiusuraReq();
		
		c.setDescrizione(null);
				
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            chiusuraS.createOrUpdate(c);
        });

        assertEquals("chiusura-desc-null", exception.getMessage());
		
	}
	
	@Test
	@Order(3)
	public void saveChiusuraDuplicate() {
		ChiusuraReq c = new ChiusuraReq();
		
		c.setDescrizione("aperto");
				
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            chiusuraS.createOrUpdate(c);
        });

        assertEquals("chiusura-exist", exception.getMessage());
		
	}
	
	@Order(4)
	public void updateChiusura() {
		ChiusuraReq c = new ChiusuraReq();
		
		c.setDescrizione("semi-aperto");
		c.setId(1);
				
		assertDoesNotThrow(() -> {
            chiusuraS.createOrUpdate(c);
        });
		
	}
	
	@Test
	@Order(5)
	public void updateIderrChiusura() {
		ChiusuraReq c = new ChiusuraReq();
		
		c.setDescrizione("semi-chiuso");
		c.setId(3);
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            chiusuraS.createOrUpdate(c);
        });

        assertEquals("chiusura-ntexist", exception.getMessage());
     		
	}
	
	@Test
	@Order(6)
	public void updateDescNullChiusura() {
		ChiusuraReq c = new ChiusuraReq();
		
		c.setId(1);
		c.setDescrizione(null);
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
	        chiusuraS.createOrUpdate(c);
	    });

        assertEquals("chiusura-desc-null", exception.getMessage());
        		
	}
	
	@Test
	@Order(7)
	public void updateDescDuplicateChiusura() {
		ChiusuraReq c = new ChiusuraReq();
		
		c.setId(2);
		c.setDescrizione("chiuso");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
	        chiusuraS.createOrUpdate(c);
	    });

        assertEquals("chiusura-exist", exception.getMessage());
        
        List<Chiusura> lc = repoC.findAll();
        lc.forEach(s -> System.out.println(s.getDesc() + "  "));
        		
	}

	
	@Test
	@Order(8)
	public void serachDescChiusura() {		

		assertDoesNotThrow(() -> {
            ChiusuraReq r =  chiusuraS.searchByDesc("aperto");
        });
	}
	
	@Test
	@Order(9)
	public void serachDescChiusuraNotExist() {		
		
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            chiusuraS.searchByDesc("irreale");
        });

        assertEquals("chiusura-ntexist", exception.getMessage());
		
	}
	
	@Test
	@Order(10)
	public void serachIdChiusura() {
		assertDoesNotThrow(() -> {
            ChiusuraReq r =  chiusuraS.searchById(1);
        });

	}
	
	@Test
	@Order(11)
	public void serachIdChiusuraNotExist() {

		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            chiusuraS.searchById(90);
        });

        assertEquals("chiusura-ntexist", exception.getMessage());
		
	}

}
