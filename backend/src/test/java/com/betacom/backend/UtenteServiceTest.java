package com.betacom.backend;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.backend.dto.UtenteDTO;
import com.betacom.backend.exception.AcademyException;
import com.betacom.backend.request.UtenteReq;
import com.betacom.backend.service.interfaces.IUtenteService;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UtenteServiceTest {

    @Autowired
    IUtenteService utenteS;

    @Test
    @Order(1)
    void testCreateWithoutException() {
        UtenteReq req = new UtenteReq();
        req.setNome("Test");
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        assertDoesNotThrow(() -> {
            utenteS.createOrUpdate(req);
        });
    }

    @Test
    @Order(2)
    void testUpdateWithoutException(){
        UtenteReq req = new UtenteReq();
        req.setId(1);
        req.setNome("Test1");
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        assertDoesNotThrow(() -> {
            utenteS.createOrUpdate(req);
        });
    }

    @Test
    @Order(3)
    void testCreateWithExceptionNoNome() {
        UtenteReq req = new UtenteReq();
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-nome-null", exception.getMessage());
    }

    @Test
    @Order(4)
    void testCreateWithExceptionNoCognome() {
        UtenteReq req = new UtenteReq();
        req.setNome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-cognome-null", exception.getMessage());
    }

    @Test
    @Order(5)
    void testCreateWithExceptionNoMail() {
        UtenteReq req = new UtenteReq();
        req.setNome("Test");
        req.setCognome("Test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-mail-null", exception.getMessage());
    }
    
    @Test
    @Order(6)
    void testCreateWithExceptionNoPassword() {
        UtenteReq req = new UtenteReq();
        req.setNome("Test");
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-password-null", exception.getMessage());
    }

    @Test
    @Order(7)
    void testCreateWithExceptionNoRuolo() {
        UtenteReq req = new UtenteReq();
        req.setNome("Test");
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-ruolo-null", exception.getMessage());
    }

    @Test
    @Order(8)
    void testUpdateWithExceptionNoNome() {
        UtenteReq req = new UtenteReq();
        req.setId(1);
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-nome-null", exception.getMessage());
    }

    @Test
    @Order(9)
    void testUpdateWithExceptionNoCognome() {
        UtenteReq req = new UtenteReq();
        req.setId(1);
        req.setNome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-cognome-null", exception.getMessage());
    }

    @Test
    @Order(10)
    void testUpdateWithExceptionNoMail() {
        UtenteReq req = new UtenteReq();
        req.setId(1);
        req.setNome("Test");
        req.setCognome("Test");
        req.setPassword("test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-mail-null", exception.getMessage());
    }
    
    @Test
    @Order(11)
    void testUpdateWithExceptionNoPassword() {
        UtenteReq req = new UtenteReq();
        req.setId(1);
        req.setNome("Test");
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setRuolo("CLIENTE");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-password-null", exception.getMessage());
    }

    @Test
    @Order(12)
    void testUpdateWithExceptionNoRuolo() {
        UtenteReq req = new UtenteReq();
        req.setId(1);
        req.setNome("Test");
        req.setCognome("Test");
        req.setMail("test@test.test");
        req.setPassword("test");

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.createOrUpdate(req);
        });

        assertEquals("utente-ruolo-null", exception.getMessage());
    }

    @Test
    @Order(13)
    void testSearchByIdWithoutException() {

        assertDoesNotThrow(() -> {
            utenteS.searchById(1);
        });
    }

    @Test
    @Order(14)
    void testSearchByIdWithException() {

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.searchById(3);
        });

        assertEquals("utente-ntexist", exception.getMessage());
    }

    @Test
    @Order(15)
    void testSearchByMailWithoutException() {

        assertDoesNotThrow(() -> {
            utenteS.searchByMail("test@test.test");
        });
    }

    @Test
    @Order(16)
    void testSearchByMailWithException() {

        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.searchByMail("fyedb@mad.e");
        });

        assertEquals("utente-no-mail", exception.getMessage());
    }

    @Test
    @Order(17)
    void testListAll() {

        List<UtenteDTO> utenti = utenteS.listAll();
        Assertions.assertThat(utenti.size()).isEqualTo(1);
    
    }

    @Test
    @Order(18)
    void testGetUtenteWithoutException() {
        assertDoesNotThrow(() -> {
            utenteS.getUtente(1);
        });
    }

    @Test
    @Order(19)
    void testGetUtenteWithException() {
        AcademyException exception = assertThrows(AcademyException.class, () -> {
            utenteS.getUtente(3);
        });
        assertEquals("utente-ntexist", exception.getMessage());
    }
}