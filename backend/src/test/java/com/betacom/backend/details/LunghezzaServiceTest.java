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
import com.betacom.backend.request.LunghezzaReq;
import com.betacom.backend.service.interfaces.ILunghezzaService;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LunghezzaServiceTest {

    @Autowired
    ILunghezzaService lunghezzaS;

    @Test
    @Order(1)
    public void testCreateWithoutException() {

        LunghezzaReq req = new LunghezzaReq();
        req.setDescrizione("piede");
        
        assertDoesNotThrow(() -> {
            lunghezzaS.createOrUpdate(req);
        });
    }

    @Test
    @Order(2)
    public void testUpdateWithoutException() {

        LunghezzaReq req = new LunghezzaReq();
        req.setId(1);
        req.setDescrizione("caviglia");
        
        assertDoesNotThrow(() -> {
            lunghezzaS.createOrUpdate(req);
        });
    }
    
    @Test
    @Order(3)
    public void testUpdateWithExceptionNotExist() {

        LunghezzaReq req = new LunghezzaReq();
        req.setId(3);
        req.setDescrizione("ginocchio");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lunghezzaS.createOrUpdate(req);
        });

        assertEquals("lunghezza-ntexist", exception.getMessage());
    }

    @Test
    @Order(4)
    public void testCreateExceptionExist() {

        LunghezzaReq req = new LunghezzaReq();
        req.setDescrizione("caviglia");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lunghezzaS.createOrUpdate(req);
        });

        assertEquals("lunghezza-exist", exception.getMessage());
    }

    @Test
    @Order(5)
    public void testUpdateExceptionExist() {

        LunghezzaReq req = new LunghezzaReq();
        req.setId(1);
        req.setDescrizione("caviglia");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lunghezzaS.createOrUpdate(req);
        });

        assertEquals("lunghezza-exist", exception.getMessage());
    }

    @Test
    @Order(6)
    public void testCreateWithExceptionDescNull() {

        LunghezzaReq req = new LunghezzaReq();
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lunghezzaS.createOrUpdate(req);
        });

        assertEquals("lunghezza-desc-null", exception.getMessage());
    }

    @Test
    @Order(7)
    public void testUpdateWithExceptionDescNull() {

        LunghezzaReq req = new LunghezzaReq();
        req.setId(1);

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lunghezzaS.createOrUpdate(req);
        });

        assertEquals("lunghezza-desc-null", exception.getMessage());
    }

    @Test
    @Order(8)
    public void testsearchByDescWithoutException() {

        assertDoesNotThrow(() -> {
            lunghezzaS.searchByDesc("caviglia");
        });
    }

    @Test
    @Order(9)
    public void testsearchByDescWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lunghezzaS.searchByDesc("cavallo");
        });

        assertEquals("lunghezza-no-desc", exception.getMessage());
    }

    @Test
    @Order(10)
    public void testsearchByIdWithoutException() {

        assertDoesNotThrow(() -> {
            lunghezzaS.searchById(1);
        });
    }

    @Test
    @Order(11)
    public void testsearchByIdWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            lunghezzaS.searchById(4);
        });

        assertEquals("lunghezza-ntexist", exception.getMessage());
    }


}
