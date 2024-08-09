package com.betacom.backend.request;

public class VestitoReq {

	private Integer id;
	private String taglia;
	private String vestibilita;
	private String lunghezza;
	private String lunghezzaManica;

	
	public VestitoReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VestitoReq(Integer id, String taglia, String vestibilita, String lunghezza, String lunghezzaManica) {
		super();
		this.id = id;
		this.taglia = taglia;
		this.vestibilita = vestibilita;
		this.lunghezza = lunghezza;
		this.lunghezzaManica = lunghezzaManica;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaglia() {
		return taglia;
	}
	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}
	public String getVestibilita() {
		return vestibilita;
	}
	public void setVestibilita(String vestibilita) {
		this.vestibilita = vestibilita;
	}
	public String getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(String lunghezza) {
		this.lunghezza = lunghezza;
	}
	public String getLunghezzaManica() {
		return lunghezzaManica;
	}
	public void setLunghezzaManica(String lunghezzaManica) {
		this.lunghezzaManica = lunghezzaManica;
	}
	
	
}
