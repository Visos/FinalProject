package com.betacom.backend.dto;

import java.util.List;

public class OrdineDTO {

    private Integer id;
    private String data;
    private String stato;
    private Integer prezzoTotale;
    private List<ProdottiOrdiniDTO> prodOrdini;
    private Integer idUtente;

    public OrdineDTO() {
    }

    public OrdineDTO(Integer id, String data, String stato, Integer prezzoTotale, List<ProdottiOrdiniDTO> prodOrdini,
            Integer idUtente) {
        this.id = id;
        this.data = data;
        this.stato = stato;
        this.prezzoTotale = prezzoTotale;
        this.prodOrdini = prodOrdini;
        this.idUtente = idUtente;
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

    public List<ProdottiOrdiniDTO> getProdOrdini() {
        return prodOrdini;
    }

    public void setProdOrdini(List<ProdottiOrdiniDTO> prodOrdini) {
        this.prodOrdini = prodOrdini;
    }

    public Integer getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Integer idUtente) {
        this.idUtente = idUtente;
    }
}
