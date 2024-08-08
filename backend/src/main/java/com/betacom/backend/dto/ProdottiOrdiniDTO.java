package com.betacom.backend.dto;

public class ProdottiOrdiniDTO {

    private Integer id;
    private Integer qty;
    private Integer idOrdine;
    private Integer idProdotto;

    public ProdottiOrdiniDTO() {
    }

    public ProdottiOrdiniDTO(Integer id, Integer qty, Integer idOrdine, Integer idProdotto) {
        this.id = id;
        this.qty = qty;
        this.idOrdine = idOrdine;
        this.idProdotto = idProdotto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Integer idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Integer getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Integer idProdotto) {
        this.idProdotto = idProdotto;
    }    
}
