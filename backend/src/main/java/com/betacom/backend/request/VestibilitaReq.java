package com.betacom.backend.request;

public class VestibilitaReq {
	
	Integer id;
	String descrizione;
	
	public VestibilitaReq() {
		super();
	}
	
	public VestibilitaReq(Integer id, String descrizione) {
		super();
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
