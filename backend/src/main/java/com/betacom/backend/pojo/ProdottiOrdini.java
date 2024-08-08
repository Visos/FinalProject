package com.betacom.backend.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotti_ordini")
public class ProdottiOrdini {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "id_ordine")
    private Ordine ordine;

    @ManyToOne
    @JoinColumn(name = "id_prodotto")
    private Prodotto prodotto;
}
