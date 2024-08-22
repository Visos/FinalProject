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
import com.betacom.backend.request.LunghezzaManicaReq;
import com.betacom.backend.service.interfaces.ILunghezzaManicaService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LunghezzaManicaServiceTest {

    @Autowired
    ILunghezzaManicaService lManicaS;

    @Test
    @Order(1)
    public void testCreateWithoutException() {

        LunghezzaManicaReq req = new LunghezzaManicaReq();
        req.setDescrizione("corte");
        
        assertDoesNotThrow(() -> {
            lManicaS.createOrUpdate(req);
        });
        
        req.setDescrizione("Corta");
        
        assertDoesNotThrow(() -> {
            lManicaS.createOrUpdate(req);
        });
    }

    @Test
    @Order(2) 
    public void testUpdateWithoutException() {

        LunghezzaManicaReq req = new LunghezzaManicaReq();
        req.setId(1);
        req.setDescrizione("polso");
        
        assertDoesNotThrow(() -> {
            lManicaS.createOrUpdate(req);
        });
    }
    
    @Test
    @Order(3)
    public void testUpdateWithExceptionNotExist() {

        LunghezzaManicaReq req = new LunghezzaManicaReq();
        req.setId(3);
        req.setDescrizione("ginocchio");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lManicaS.createOrUpdate(req);
        });

        assertEquals("lManica-ntexist", exception.getMessage());
    }

    @Test
    @Order(4)
    public void testCreateExceptionExist() {

        LunghezzaManicaReq req = new LunghezzaManicaReq();
        req.setDescrizione("polso");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lManicaS.createOrUpdate(req);
        });

        assertEquals("lManica-exist", exception.getMessage());
    }

    @Test
    @Order(5)
    public void testUpdateExceptionExist() {

        LunghezzaManicaReq req = new LunghezzaManicaReq();
        req.setId(1);
        req.setDescrizione("polso");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lManicaS.createOrUpdate(req);
        });

        assertEquals("lManica-exist", exception.getMessage());
    }
    @Test
    @Order(6)
    public void testCreateWithExceptionDescNull() {

        LunghezzaManicaReq req = new LunghezzaManicaReq();
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lManicaS.createOrUpdate(req);
        });

        assertEquals("lManica-desc-null", exception.getMessage());
    }

    @Test
    @Order(7)
    public void testUpdateWithExceptionDescNull() {

        LunghezzaManicaReq req = new LunghezzaManicaReq();
        req.setId(1);

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lManicaS.createOrUpdate(req);
        });

        assertEquals("lManica-desc-null", exception.getMessage());
    }

    @Test
    @Order(8)
    public void testSearchByDescWithoutException() {

        assertDoesNotThrow(() -> {
            lManicaS.searchByDesc("polso");
        });
    }

    @Test
    @Order(9)
    public void testSearchByDescWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lManicaS.searchByDesc("cavallo");
        });

        assertEquals("lManica-no-desc", exception.getMessage());
    }

    @Test
    @Order(10)
    public void testSearchByIdWithoutException() {

        assertDoesNotThrow(() -> {
            lManicaS.searchById(1);
        });
    }

    @Test
    @Order(11)
    public void testSearchByIdWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lManicaS.searchById(4);
        });

        assertEquals("lManica-ntexist", exception.getMessage());
    }

    @Test
    @Order(12)
    public void testListAll() {
        lManicaS.listAll();
        assertEquals(1, lManicaS.listAll().size());
    }
}
