package com.betacom.backend.pojo;

import java.util.List;

import com.betacom.backend.util.Stato;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String data;

    @Column(nullable = false)
    private Stato stato;

    @Column(nullable = false, name = "prezzo_totale")
    private Integer prezzoTotale;

    @Column(nullable = false)
    private Integer qty;

    @OneToMany(mappedBy = "ordine")
    private List<ProdottiOrdini> prodOrdini;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    public Ordine() {
    }

    public Ordine(Integer id, String data, Stato stato, Integer prezzoTotale, Integer qty, List<ProdottiOrdini> prodOrdini, Utente utente) {
        this.id = id;
        this.data = data;
        this.stato = stato;
        this.prezzoTotale = prezzoTotale;
        this.qty = qty;
        this.prodOrdini = prodOrdini;
        this.utente = utente;
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

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<ProdottiOrdini> getProdOrdini() {
        return prodOrdini;
    }

    public void setProdOrdini(List<ProdottiOrdini> prodOrdini) {
        this.prodOrdini = prodOrdini;
    }
}
