package com.betacom.backend.request;

public class LunghezzaReq {

    private Integer id;
    private String descrizione;

    public LunghezzaReq() {
    }

    public LunghezzaReq(Integer id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
