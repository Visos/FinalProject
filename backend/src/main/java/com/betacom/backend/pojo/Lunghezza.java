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
@Table(name = "lunghezza")
public class Lunghezza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
        name = "descrizione", 
        length = 45,
        nullable = false)
    private String desc;

    @OneToMany(
        mappedBy = "lunghezza",
        fetch = FetchType.EAGER)
    private List<Vestito> vestiti;

    @OneToMany(
        mappedBy = "lunghezza",
        fetch = FetchType.EAGER)
    private List<Pantalone> pantaloni;

    public Lunghezza() {
    }

    public Lunghezza(Integer id, String desc, List<Vestito> vestiti, List<Pantalone> pantaloni) {
        this.id = id;
        this.desc = desc;
        this.vestiti = vestiti;
        this.pantaloni = pantaloni;
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

    public List<Vestito> getVestiti() {
        return vestiti;
    }

    public void setVestiti(List<Vestito> vestiti) {
        this.vestiti = vestiti;
    }

    public List<Pantalone> getPantaloni() {
        return pantaloni;
    }

    public void setPantaloni(List<Pantalone> pantaloni) {
        this.pantaloni = pantaloni;
    }
}
