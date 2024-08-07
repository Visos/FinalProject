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
@Table(name = "scarpa")
public class Scarpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
        name = "taglia_scarpe", 
        nullable = false,
        length = 2
    )
    private Integer tagliaScarpe;

    @ManyToOne
    @JoinColumn(name = "id_chiusura")
    private Chiusura chiusura;

    @ManyToOne
    @JoinColumn(name = "id_tipo_scarpa")
    private TipoScarpa tipoScarpa;

    public Scarpa() {
    }

    public Scarpa(Integer id, Integer tagliaScarpe, Chiusura chiusura, TipoScarpa tipoScarpa) {
        this.id = id;
        this.tagliaScarpe = tagliaScarpe;
        this.chiusura = chiusura;
        this.tipoScarpa = tipoScarpa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagliaScarpe() {
        return tagliaScarpe;
    }

    public void setTagliaScarpe(Integer tagliaScarpe) {
        this.tagliaScarpe = tagliaScarpe;
    }

    public Chiusura getChiusura() {
        return chiusura;
    }

    public void setChiusura(Chiusura chiusura) {
        this.chiusura = chiusura;
    }

    public TipoScarpa getTipoScarpa() {
        return tipoScarpa;
    }

    public void setTipoScarpa(TipoScarpa tipoScarpa) {
        this.tipoScarpa = tipoScarpa;
    }
}
