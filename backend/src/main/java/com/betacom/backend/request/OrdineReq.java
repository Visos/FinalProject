package com.betacom.backend.request;

import java.util.List;

public class OrdineReq {

    private Integer id;
    private String data;
    private String stato;
    private Integer prezzoTotale;
    private Integer qty;
    private List<ProdottiOrdiniReq> prodOrdiniReq;
    private UtenteReq utenteReq;
    
    public OrdineReq() {
    }

    public OrdineReq(Integer id, String data, String stato, Integer prezzoTotale, Integer qty,
        List<ProdottiOrdiniReq> prodOrdiniReq, UtenteReq utenteReq) {
        this.id = id;
        this.data = data;
        this.stato = stato;
        this.prezzoTotale = prezzoTotale;
        this.qty = qty;
        this.prodOrdiniReq = prodOrdiniReq;
        this.utenteReq = utenteReq;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Integer getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(Integer prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
    public List<ProdottiOrdiniReq> getProdOrdiniReq() {
        return prodOrdiniReq;
    }

    public void setProdOrdiniReq(List<ProdottiOrdiniReq> prodOrdiniReq) {
        this.prodOrdiniReq = prodOrdiniReq;
    }

    public UtenteReq getUtenteReq() {
        return utenteReq;
    }

    public void setUtenteReq(UtenteReq utenteReq) {
        this.utenteReq = utenteReq;
    }

    
}
