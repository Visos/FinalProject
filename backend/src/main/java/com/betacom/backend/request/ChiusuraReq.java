package com.betacom.backend.request;

public class ChiusuraReq {
	
	private Integer id;
	private String descrizione;
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
	public ChiusuraReq(Integer id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
	}
	
	public ChiusuraReq() {
		super();
		
	}
	
	
	

}
