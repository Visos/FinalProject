package com.betacom.backend.request;

import java.util.List;

public class OrdineReq {

    private Integer id;
    private String data;
    private String stato;
    private Double prezzoTotale;
    private Integer qty;
    private Integer idUtente;
    private List<ProdottiOrdiniReq> prodOrdiniReq;
    
    public OrdineReq() {
    }

    public OrdineReq(Integer id, String data, String stato, Double prezzoTotale, Integer qty,
        Integer idUtente, List<ProdottiOrdiniReq> prodOrdiniReq) {
        this.id = id;
        this.data = data;
        this.stato = stato;
        this.prezzoTotale = prezzoTotale;
        this.qty = qty;
        this.idUtente = idUtente;
        this.prodOrdiniReq = prodOrdiniReq;
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

    public Double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(Double prezzoTotale) {
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

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }
}
