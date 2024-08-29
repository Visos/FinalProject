package com.betacom.backend.request;

public class PantaloneReq {
	private Integer id;
    private String taglia;
    private String vestibilita;
    private String lunghezza;

    public PantaloneReq() {
    }

    public PantaloneReq(Integer id, String taglia, String vestibilita, String lunghezza) {
        this.id = id;
        this.taglia = taglia;
        this.vestibilita = vestibilita;
        this.lunghezza = lunghezza;
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
}
