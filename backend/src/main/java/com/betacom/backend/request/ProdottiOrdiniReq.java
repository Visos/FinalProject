package com.betacom.backend.request;

import com.betacom.backend.pojo.Ordine;
import com.betacom.backend.pojo.Prodotto;

public class ProdottiOrdiniReq {

    private Integer id;
    private Integer qty;
    private OrdineReq ordineReq;
    private ProdottoReq prodottoReq;

    public ProdottiOrdiniReq() {
    }

    public ProdottiOrdiniReq(Integer id, Integer qty, OrdineReq ordineReq, ProdottoReq prodottoReq) {
        this.id = id;
        this.qty = qty;
        this.ordineReq = ordineReq;
        this.prodottoReq = prodottoReq;
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

    public OrdineReq getOrdineReq() {
        return ordineReq;
    }

    public void setOrdineReq(OrdineReq ordineReq) {
        this.ordineReq = ordineReq;
    }

    public ProdottoReq getProdottoReq() {
        return prodottoReq;
    }

    public void setProdottoReq(ProdottoReq prodottoReq) {
        this.prodottoReq = prodottoReq;
    }

}
    
