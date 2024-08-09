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
import com.betacom.backend.pojo.Colore;
import com.betacom.backend.repository.IColoreRepository;
import com.betacom.backend.request.ColoreReq;
import com.betacom.backend.service.interfaces.IColoreService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ColoreServiceTest {
	
	@Autowired
	IColoreRepository repoC;
	
	@Autowired
	IColoreService colS;
	
	@Test
	@Order(1)
	public void saveColore() {
		ColoreReq c = new ColoreReq();
		
		c.setDescrizione("rosso");
				
		assertDoesNotThrow(() -> {
            colS.createOrUpdate(c);
        });
		
		c.setDescrizione("blu");
		
		assertDoesNotThrow(() -> {
            colS.createOrUpdate(c);
        });
		
	}
	
	@Test
	@Order(2)
	public void saveColoreNull() {
		ColoreReq c = new ColoreReq();
		
		c.setDescrizione(null);
				
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            colS.createOrUpdate(c);
        });

        assertEquals("colore-desc-null", exception.getMessage());
		
	}
	@Test
	@Order(3)
	public void saveColoreDuplicate() {
		ColoreReq c = new ColoreReq();
		
		c.setDescrizione("rosso");
				
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            colS.createOrUpdate(c);
        });

        assertEquals("colore-exist", exception.getMessage());
		
	}
	
	@Order(4)
	public void updateColore() {
		ColoreReq c = new ColoreReq();
		
		c.setDescrizione("giallo");
		c.setId(1);
				
		assertDoesNotThrow(() -> {
            colS.createOrUpdate(c);
        });
		
	}
	
	@Test
	@Order(5)
	public void updateIderrColore() {
		ColoreReq c = new ColoreReq();
		
		c.setDescrizione("verde");
		c.setId(3);
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            colS.createOrUpdate(c);
        });

        assertEquals("colore-ntexist", exception.getMessage());
     		
	}
	
	@Test
	@Order(6)
	public void updateDescNullColore() {
		ColoreReq c = new ColoreReq();
		
		c.setId(1);
		c.setDescrizione(null);
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
	        colS.createOrUpdate(c);
	    });

        assertEquals("colore-desc-null", exception.getMessage());
        		
	}
	
	@Test
	@Order(7)
	public void updateDescDuplicateColore() {
		ColoreReq c = new ColoreReq();
		
		c.setId(2);
		c.setDescrizione("blu");
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
	        colS.createOrUpdate(c);
	    });

        assertEquals("colore-exist", exception.getMessage());
        
        List<Colore> lc = repoC.findAll();
        lc.forEach(s-> System.out.println(s.getDesc() + "  "));
        		
	}
	

	
	
	
	
	@Test
	@Order(100)
	public void serachDescColore() {
		ColoreReq c = new ColoreReq();
		

		assertDoesNotThrow(() -> {
            ColoreReq r =  colS.searchByDesc("rosso");
        });
		
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            colS.searchByDesc("assurdo");
        });

        assertEquals("colore-ntexist", exception.getMessage());
		
	}
	
	@Test
	@Order(101)
	public void serachIdColore() {
		ColoreReq c = new ColoreReq();
		

		assertDoesNotThrow(() -> {
            ColoreReq r =  colS.searchById(1);
        });
		
		
		AcademyException exception = assertThrows(AcademyException.class, () -> {
            colS.searchById(90);
        });

        assertEquals("colore-ntexist", exception.getMessage());
		
	}

	
	

	

}
