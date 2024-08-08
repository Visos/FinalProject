package com.betacom.backend.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_colletto")
public class TipoColletto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
        name = "descrizione", 
        length = 45,
        nullable = false)
    private String desc;

    @OneToMany(
        mappedBy = "tipoColletto",
        fetch = FetchType.EAGER)
    private List<Camicia> camicie;

    @OneToMany(
        mappedBy = "tipoColletto",
        fetch = FetchType.EAGER)
    private List<Maglietta> magliette;

    public TipoColletto() {
    }

    public TipoColletto(Integer id, String desc, List<Camicia> camicie, List<Maglietta> magliette) {
        this.id = id;
        this.desc = desc;
        this.camicie = camicie;
        this.magliette = magliette;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Camicia> getCamicie() {
        return camicie;
    }

    public void setCamicie(List<Camicia> camicie) {
        this.camicie = camicie;
    }

    public List<Maglietta> getMagliette() {
        return magliette;
    }

    public void setMagliette(List<Maglietta> magliette) {
        this.magliette = magliette;
    }
}
