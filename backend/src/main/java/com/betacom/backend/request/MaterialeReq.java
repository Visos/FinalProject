package com.betacom.backend.request;

public class MaterialeReq {

    private Integer id;
    private String descrizione;

    public MaterialeReq() {
    }

    public MaterialeReq(Integer id, String descrizione) {
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
