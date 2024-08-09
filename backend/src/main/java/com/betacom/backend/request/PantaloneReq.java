package com.betacom.backend.request;

public class PantaloneReq {
	private Integer id;
    private String taglia;
    private String vestibilita;
    private Integer lunghezza;

    public PantaloneReq() {
    }

    public PantaloneReq(Integer id, String taglia, String vestibilita, Integer lunghezza) {
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

	public Integer getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Integer lunghezza) {
		this.lunghezza = lunghezza;
	}
}
