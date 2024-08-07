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
@Table(name = "lunghezza_manica")
public class LunghezzaManica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(
        name = "descrizione", 
        length = 45,
        nullable = false)
    private String desc;

    @OneToMany(
        mappedBy = "lunghezza_manica",
        fetch = FetchType.EAGER)
    private List<Camicia> camicie;

    @OneToMany(
        mappedBy = "lunghezza_manica",
        fetch = FetchType.EAGER)
    private List<Vestito> vestiti;

    @OneToMany(
        mappedBy = "lunghezza_manica",
        fetch = FetchType.EAGER)
    private List<Maglietta> magliette;
    
    public LunghezzaManica() {
        super();
    }
    
    public LunghezzaManica(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
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
}
