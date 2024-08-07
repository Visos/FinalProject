package com.betacom.backend.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pantalone")
public class Pantalone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_taglia")
    private Taglia taglia;

    @ManyToOne
    @JoinColumn(name = "id_vestibilita")
    private Vestibilita vestibilita;

    @ManyToOne
    @JoinColumn(name = "id_lunghezza")
    private Lunghezza lunghezza;

    public Pantalone() {
    }

    public Pantalone(Integer id, Taglia taglia, Vestibilita vestibilita, Lunghezza lunghezza) {
        this.id = id;
        this.taglia = taglia;
        this.vestibilita = vestibilita;
        this.lunghezza = lunghezza;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Taglia getTaglia() {
        return taglia;
    }

    public void setTaglia(Taglia taglia) {
        this.taglia = taglia;
    }

    public Vestibilita getVestibilita() {
        return vestibilita;
    }

    public void setVestibilita(Vestibilita vestibilita) {
        this.vestibilita = vestibilita;
    }

    public Lunghezza getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(Lunghezza lunghezza) {
        this.lunghezza = lunghezza;
    }
}
