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
import com.betacom.backend.request.MaterialeReq;
import com.betacom.backend.service.interfaces.IMaterialeService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MaterialeServiceTest {

    @Autowired
    IMaterialeService materialeS;

     @Test
    @Order(1)
    public void testCreateWithoutException() {

        MaterialeReq req = new MaterialeReq();
        req.setDescrizione("seta");
        
        assertDoesNotThrow(() -> {
            materialeS.createOrUpdate(req);
        });
    }

    @Test
    @Order(2)
    public void testUpdateWithoutException() {

        MaterialeReq req = new MaterialeReq();
        req.setId(1);
        req.setDescrizione("lino");
        
        assertDoesNotThrow(() -> {
            materialeS.createOrUpdate(req);
        });
    }
    
    @Test
    @Order(3)
    public void testUpdateWithExceptionNotExist() {

        MaterialeReq req = new MaterialeReq();
        req.setId(3);
        req.setDescrizione("jeans");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            materialeS.createOrUpdate(req);
        });

        assertEquals("materiale-ntexist", exception.getMessage());
    }

    @Test
    @Order(4)
    public void testCreateExceptionExist() {

        MaterialeReq req = new MaterialeReq();
        req.setDescrizione("lino");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            materialeS.createOrUpdate(req);
        });

        assertEquals("materiale-exist", exception.getMessage());
    }

    @Test
    @Order(5)
    public void testUpdateExceptionExist() {

        MaterialeReq req = new MaterialeReq();
        req.setId(1);
        req.setDescrizione("lino");
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            materialeS.createOrUpdate(req);
        });

        assertEquals("materiale-exist", exception.getMessage());
    }

    @Test
    @Order(6)
    public void testCreateWithExceptionDescNull() {

        MaterialeReq req = new MaterialeReq();
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            materialeS.createOrUpdate(req);
        });

        assertEquals("materiale-desc-null", exception.getMessage());
    }

    @Test
    @Order(7)
    public void testUpdateWithExceptionDescNull() {

        MaterialeReq req = new MaterialeReq();
        req.setId(1);

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            materialeS.createOrUpdate(req);
        });

        assertEquals("materiale-desc-null", exception.getMessage());
    }

    @Test
    @Order(8)
    public void testsearchByDescWithoutException() {

        assertDoesNotThrow(() -> {
            materialeS.searchByDesc("lino");
        });
    }

    @Test
    @Order(9)
    public void testsearchByDescWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            materialeS.searchByDesc("seta");
        });

        assertEquals("materiale-no-desc", exception.getMessage());
    }

    @Test
    @Order(10)
    public void testsearchByIdWithoutException() {

        assertDoesNotThrow(() -> {
            materialeS.searchById(1);
        });
    }

    @Test
    @Order(11)
    public void testsearchByIdWithException() {
        
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            materialeS.searchById(4);
        });

        assertEquals("materiale-ntexist", exception.getMessage());
    }

}
