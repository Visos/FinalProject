package com.betacom.backend.request;

import java.util.List;

public class ProdottoReq {

	private Integer id;
	private Integer qty;
	private String sesso;
	private String colore;
	private String marca;
	private String materiale;
	private String fantasia;
	private MagliettaReq magliettaReq;
	private PantaloneReq pantaloneReq;
	private VestitoReq vestitoReq;
	private ScarpaReq scarpaReq;
	private CamiciaReq camiciaReq;
	private Double prezzo;
	private List<ProdottiOrdiniReq> listProdOrdiniReq;


	public ProdottoReq() {
	}

	public ProdottoReq(Integer id, Integer qty, String sesso, String colore, String marca, String materiale,
			String fantasia, MagliettaReq magliettaReq, PantaloneReq pantaloneReq, VestitoReq vestitoReq,
			ScarpaReq scarpaReq, CamiciaReq camiciaReq, Double prezzo) {
		this.id = id;
		this.qty = qty;
		this.sesso = sesso;
		this.colore = colore;
		this.marca = marca;
		this.materiale = materiale;
		this.fantasia = fantasia;
		this.magliettaReq = magliettaReq;
		this.pantaloneReq = pantaloneReq;
		this.vestitoReq = vestitoReq;
		this.scarpaReq = scarpaReq;
		this.camiciaReq = camiciaReq;
		this.prezzo = prezzo;
	}

	public Integer getId() {
		return id;
	}

	public List<ProdottiOrdiniReq> getListProdOrdiniReq() {
		return listProdOrdiniReq;
	}

	public void setListProdOrdiniReq(List<ProdottiOrdiniReq> listProdOrdiniReq) {
		this.listProdOrdiniReq = listProdOrdiniReq;
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

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMateriale() {
		return materiale;
	}

	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public MagliettaReq getMagliettaReq() {
		return magliettaReq;
	}

	public void setMagliettaReq(MagliettaReq magliettaReq) {
		this.magliettaReq = magliettaReq;
	}

	public PantaloneReq getPantaloneReq() {
		return pantaloneReq;
	}

	public void setPantaloneReq(PantaloneReq pantaloneReq) {
		this.pantaloneReq = pantaloneReq;
	}

	public VestitoReq getVestitoReq() {
		return vestitoReq;
	}

	public void setVestitoReq(VestitoReq vestitoReq) {
		this.vestitoReq = vestitoReq;
	}

	public ScarpaReq getScarpaReq() {
		return scarpaReq;
	}

	public void setScarpaReq(ScarpaReq scarpaReq) {
		this.scarpaReq = scarpaReq;
	}

	public CamiciaReq getCamiciaReq() {
		return camiciaReq;
	}

	public void setCamiciaReq(CamiciaReq camiciaReq) {
		this.camiciaReq = camiciaReq;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

}
