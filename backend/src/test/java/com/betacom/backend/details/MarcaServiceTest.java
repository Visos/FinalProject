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
import com.betacom.backend.request.MarcaReq;
import com.betacom.backend.service.interfaces.IMarcaService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MarcaServiceTest {

    @Autowired
    IMarcaService marcaS;

    @Test
    @Order(1)
    public void testCreateWithoutException() {

        MarcaReq req = new MarcaReq();
        req.setDescrizione("Adidas");
        
        assertDoesNotThrow(() -> {
            marcaS.createOrUpdate(req);
        });
    }

    @Test
    @Order(2)
    public void testUpdateWithoutException() {

        MarcaReq req = new MarcaReq();
        req.setId(1);
        req.setDescrizione("Nike");
        
        assertDoesNotThrow(() -> {
            marcaS.createOrUpdate(req);
        });
    }
    
    @Test
    @Order(3)
    public void testUpdateWithExceptionNotExist() {

        MarcaReq req = new MarcaReq();
        req.setId(3);
        req.setDescrizione("Puma");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            marcaS.createOrUpdate(req);
        });

        assertEquals("marca-ntexist", exception.getMessage());
    }

    @Test
    @Order(4)
    public void testCreateExceptionExist() {

        MarcaReq req = new MarcaReq();
        req.setDescrizione("Nike");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            marcaS.createOrUpdate(req);
        });

        assertEquals("marca-exist", exception.getMessage());
    }

    @Test
    @Order(5)
    public void testUpdateExceptionExist() {

        MarcaReq req = new MarcaReq();
        req.setId(1);
        req.setDescrizione("Nike");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            marcaS.createOrUpdate(req);
        });

        assertEquals("marca-exist", exception.getMessage());
    }

    @Test
    @Order(6)
    public void testCreateWithExceptionDescNull() {

        MarcaReq req = new MarcaReq();
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            marcaS.createOrUpdate(req);
        });

        assertEquals("marca-desc-null", exception.getMessage());
    }

    @Test
    @Order(7)
    public void testUpdateWithExceptionDescNull() {

        MarcaReq req = new MarcaReq();
        req.setId(1);

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            marcaS.createOrUpdate(req);
        });

        assertEquals("marca-desc-null", exception.getMessage());
    }

    @Test
    @Order(8)
    public void testsearchByDescWithoutException() {

        assertDoesNotThrow(() -> {
            marcaS.searchByDesc("Nike");
        });
    }

    @Test
    @Order(9)
    public void testsearchByDescWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            marcaS.searchByDesc("cavallo");
        });

        assertEquals("marca-no-desc", exception.getMessage());
    }

    @Test
    @Order(10)
    public void testsearchByIdWithoutException() {

        assertDoesNotThrow(() -> {
            marcaS.searchById(1);
        });
    }

    @Test
    @Order(11)
    public void testsearchByIdWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            marcaS.searchById(4);
        });

        assertEquals("marca-ntexist", exception.getMessage());
    }
}
