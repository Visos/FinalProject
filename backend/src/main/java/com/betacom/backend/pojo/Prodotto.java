package com.betacom.backend.pojo;

import java.util.List;

import com.betacom.backend.util.Sesso;

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
@Table(name = "prodotto")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer qty;

    @Column(nullable = false)
    private Sesso sesso;

    @ManyToOne
    @JoinColumn(name = "id_colore")
    private Colore colore;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_materiale")
    private Materiale materiale;

    @ManyToOne
    @JoinColumn(name = "id_fantasia")
    private Fantasia fantasia;
    
    @ManyToOne
    @JoinColumn(name = "id_maglietta")
    private Maglietta maglietta;

    @ManyToOne
    @JoinColumn(name = "id_pantalone")
    private Pantalone pantalone;

    @ManyToOne
    @JoinColumn(name = "id_vestito")
    private Vestito vestito;

    @ManyToOne
    @JoinColumn(name = "id_scarpa")
    private Scarpa scarpa;

    @ManyToOne
    @JoinColumn(name = "id_camicia")
    private Camicia camicia;

    @OneToMany(mappedBy = "prodotto")
    private List<ProdottiOrdini>  prodOrdini;
    
    @Column(nullable = false)
    private Integer prezzo;

    public Prodotto() {
    }



    public Prodotto(Integer id, Integer qty, Sesso sesso, Colore colore, Marca marca, Materiale materiale,
			Fantasia fantasia, Maglietta maglietta, Pantalone pantalone, Vestito vestito, Scarpa scarpa,
			Camicia camicia, List<ProdottiOrdini> prodOrdini, Integer prezzo) {
		super();
		this.id = id;
		this.qty = qty;
		this.sesso = sesso;
		this.colore = colore;
		this.marca = marca;
		this.materiale = materiale;
		this.fantasia = fantasia;
		this.maglietta = maglietta;
		this.pantalone = pantalone;
		this.vestito = vestito;
		this.scarpa = scarpa;
		this.camicia = camicia;
		this.prodOrdini = prodOrdini;
		this.prezzo = prezzo;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Materiale getMateriale() {
        return materiale;
    }

    public void setMateriale(Materiale materiale) {
        this.materiale = materiale;
    }

    public Fantasia getFantasia() {
        return fantasia;
    }

    public void setFantasia(Fantasia fantasia) {
        this.fantasia = fantasia;
    }

    public Maglietta getMaglietta() {
        return maglietta;
    }

    public void setMaglietta(Maglietta maglietta) {
        this.maglietta = maglietta;
    }

    public Pantalone getPantalone() {
        return pantalone;
    }

    public void setPantalone(Pantalone pantalone) {
        this.pantalone = pantalone;
    }

    public Vestito getVestito() {
        return vestito;
    }

    public void setVestito(Vestito vestito) {
        this.vestito = vestito;
    }

    public Scarpa getScarpa() {
        return scarpa;
    }

    public void setScarpa(Scarpa scarpa) {
        this.scarpa = scarpa;
    }

    public Camicia getCamicia() {
        return camicia;
    }

    public void setCamicia(Camicia camicia) {
        this.camicia = camicia;
    }

    public List<ProdottiOrdini> getProdOrdini() {
        return prodOrdini;
    }

    public void setProdOrdini(List<ProdottiOrdini> prodOrdini) {
        this.prodOrdini = prodOrdini;
    }



	public Integer getPrezzo() {
		return prezzo;
	}



	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
    
}
