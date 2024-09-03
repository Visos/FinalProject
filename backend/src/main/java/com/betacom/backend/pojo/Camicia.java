package com.betacom.backend.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "camicia")
public class Camicia {

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
    @JoinColumn(name = "id_lunghezza_manica")
    private LunghezzaManica lunghezzaManica;

    @ManyToOne
    @JoinColumn(name = "id_tipo_colletto")
    private TipoColletto tipoColletto;

    public Camicia() {
    }

    public Camicia(Integer id, Taglia taglia, Vestibilita vestibilita, LunghezzaManica lunghezzaManica,
            TipoColletto tipoColletto) {
        this.id = id;
        this.taglia = taglia;
        this.vestibilita = vestibilita;
        this.lunghezzaManica = lunghezzaManica;
        this.tipoColletto = tipoColletto;
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

    public LunghezzaManica getLunghezzaManica() {
        return lunghezzaManica;
    }

    public void setLunghezzaManica(LunghezzaManica lunghezzaManica) {
        this.lunghezzaManica = lunghezzaManica;
    }

    public TipoColletto getTipoColletto() {
        return tipoColletto;
    }

    public void setTipoColletto(TipoColletto tipoColletto) {
        this.tipoColletto = tipoColletto;
    }
    
    
}
