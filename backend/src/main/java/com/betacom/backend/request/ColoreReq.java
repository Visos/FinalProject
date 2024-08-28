package com.betacom.backend.request;

import java.util.List;

import com.betacom.backend.dto.ProdottoDTO;

public class ColoreReq {
	
	private Integer id;
	private String descrizione;
	private List<ProdottoDTO> prodotti;
	
	
	public List<ProdottoDTO> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<ProdottoDTO> prodotti) {
		this.prodotti = prodotti;
	}

	public ColoreReq() {
	}

	public ColoreReq(Integer id, String descrizione, List<ProdottoDTO> prodotti) {
		this.id = id;
		this.descrizione = descrizione;
		this.prodotti = prodotti;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
}
