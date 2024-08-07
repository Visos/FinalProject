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
@Table(name = "tipo_scarpa")
public class TipoScarpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
        name = "descrizione", 
        length = 45,
        nullable = false)
    private String desc;

    @OneToMany(
        mappedBy = "chiusura",
        fetch = FetchType.EAGER)
    private List<Scarpa> scarpe;

    public TipoScarpa() {
        super();
    }

    public TipoScarpa(Integer id, String desc, List<Scarpa> scarpe) {
        this.id = id;
        this.desc = desc;
        this.scarpe = scarpe;
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

    public List<Scarpa> getScarpe() {
        return scarpe;
    }

    public void setScarpe(List<Scarpa> scarpe) {
        this.scarpe = scarpe;
    }

}
