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
@Table(name = "taglia")
public class Taglia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
        name = "descrizione", 
        length = 45,
        nullable = false)
    private String desc;

    @OneToMany(
        mappedBy = "taglia",
        fetch = FetchType.EAGER)
    private List<Camicia> camicie;

    @OneToMany(
        mappedBy = "taglia",
        fetch = FetchType.EAGER)
    private List<Vestito> vestiti;

    @OneToMany(
        mappedBy = "taglia",
        fetch = FetchType.EAGER)
    private List<Pantalone> pantaloni;
    
    @OneToMany(
        mappedBy = "taglia",
        fetch = FetchType.EAGER)
    private List<Maglietta> magliette;

    public Taglia() {
    }

    public Taglia(Integer id, String desc, List<Camicia> camicie, List<Vestito> vestiti, List<Pantalone> pantaloni,
            List<Maglietta> magliette) {
        this.id = id;
        this.desc = desc;
        this.camicie = camicie;
        this.vestiti = vestiti;
        this.pantaloni = pantaloni;
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

    public List<Maglietta> getMagliette() {
        return magliette;
    }

    public void setMagliette(List<Maglietta> magliette) {
        this.magliette = magliette;
    }
}
