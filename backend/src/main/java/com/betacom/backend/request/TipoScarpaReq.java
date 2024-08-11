package com.betacom.backend.request;

public class TipoScarpaReq {
	
	Integer id;
	String descrizione;
	
	public TipoScarpaReq() {
	}
	
	public TipoScarpaReq(Integer id, String descrizione) {
		this.id = id;
		this.descrizione = descrizione;
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
