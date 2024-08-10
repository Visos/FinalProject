package com.betacom.backend.request;

public class FantasiaReq {
	
	private Integer id;
	private String descrizione;
	
	public FantasiaReq() {
		super();
	}
	
	public FantasiaReq(Integer id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}
	public void setDescrizione(String descrizione) {
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
	
}
