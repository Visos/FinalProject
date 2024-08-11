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
import com.betacom.backend.pojo.Fantasia;
import com.betacom.backend.repository.IFantasiaRepository;
import com.betacom.backend.request.FantasiaReq;
import com.betacom.backend.service.interfaces.IFantasiaService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FantasiaServiceTest {
	
	@Autowired
	IFantasiaRepository repoF;
	
	@Autowired
	IFantasiaService fantasiaS;
	
	@Test
	@Order(1)
	public void saveFantasia() {
		FantasiaReq f = new FantasiaReq();
		
		f.setDescrizione("a righe");
				
		assertDoesNotThrow(() -> {
            fantasiaS.createOrUpdate(f);
        });
		
		f.setDescrizione("a pois");
		
		assertDoesNotThrow(() -> {
            fantasiaS.createOrUpdate(f);
        });
		
	}
	
	@Test
	@Order(2)
	public void saveFantasiaNull() {
		FantasiaReq f = new FantasiaReq();
		
		f.setDescrizione(null);
				
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            fantasiaS.createOrUpdate(f);
        });

        assertEquals("fantasia-desc-null", exception.getMessage());
		
	}
	
	@Test
	@Order(3)
	public void saveFantasiaDuplicate() {
		FantasiaReq f = new FantasiaReq();
		
		f.setDescrizione("a righe");
				
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            fantasiaS.createOrUpdate(f);
        });

        assertEquals("fantasia-exist", exception.getMessage());
		
	}
	
	@Order(4)
	public void updateFantasia() {
		FantasiaReq f = new FantasiaReq();
		
		f.setDescrizione("a quadretti");
		f.setId(1);
				
		assertDoesNotThrow(() -> {
            fantasiaS.createOrUpdate(f);
        });
		
	}
	
	@Test
	@Order(5)
	public void updateIderrFantasia() {
		FantasiaReq f = new FantasiaReq();
		
		f.setDescrizione("a fiori");
		f.setId(3);
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            fantasiaS.createOrUpdate(f);
        });

        assertEquals("fantasia-ntexist", exception.getMessage());
     		
	}
	
	@Test
	@Order(6)
	public void updateDescNullFantasia() {
		FantasiaReq f = new FantasiaReq();
		
		f.setId(1);
		f.setDescrizione(null);
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
	        fantasiaS.createOrUpdate(f);
	    });

        assertEquals("fantasia-desc-null", exception.getMessage());
        		
	}
	
	@Test
	@Order(7)
	public void updateDescDuplicateFantasia() {
		FantasiaReq f = new FantasiaReq();
		
		f.setId(2);
		f.setDescrizione("a pois");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
	        fantasiaS.createOrUpdate(f);
	    });

        assertEquals("fantasia-exist", exception.getMessage());
        
        List<Fantasia> lf = repoF.findAll();
        lf.forEach(s -> System.out.println(s.getDesc() + "  "));
        		
	}

	
	@Test
	@Order(8)
	public void serachDescFantasia() {		

		assertDoesNotThrow(() -> {
            fantasiaS.searchByDesc("a righe");
        });
	}
	
	@Test
	@Order(9)
	public void serachDescFantasiaNotExist() {		
		
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            fantasiaS.searchByDesc("astratta");
        });

        assertEquals("fantasia-ntexist", exception.getMessage());
		
	}
	
	@Test
	@Order(10)
	public void serachIdFantasia() {
		assertDoesNotThrow(() -> {
            fantasiaS.searchById(1);
        });

	}
	
	@Test
	@Order(11)
	public void serachIdFantasiaNotExist() {

		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            fantasiaS.searchById(90);
        });

        assertEquals("fantasia-ntexist", exception.getMessage());
		
	}

}
