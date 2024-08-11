package com.betacom.backend.request;

public class TagliaReq {

	Integer id;
	String descrizione;
	
	public TagliaReq() {
	}
	
	public TagliaReq(Integer id, String descrizione) {
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
