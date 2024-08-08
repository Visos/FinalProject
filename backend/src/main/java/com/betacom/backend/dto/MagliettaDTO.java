package com.betacom.backend.dto;


public class MagliettaDTO {
	
    private Integer id;
    private String taglia;
    private String vestibilita;
    private Integer lunghezzaManica;
    private String tipoColletto;

    public MagliettaDTO() {
    }
    
    public MagliettaDTO(Integer id, String taglia, String vestibilita, Integer lunghezzaManica,
    		String tipoColletto) {
        this.id = id;
        this.taglia = taglia;
        this.vestibilita = vestibilita;
        this.lunghezzaManica = lunghezzaManica;
        this.tipoColletto = tipoColletto;
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

	public Integer getLunghezzaManica() {
		return lunghezzaManica;
	}

	public void setLunghezzaManica(Integer lunghezzaManica) {
		this.lunghezzaManica = lunghezzaManica;
	}

	public String getTipoColletto() {
		return tipoColletto;
	}

	public void setTipoColletto(String tipoColletto) {
		this.tipoColletto = tipoColletto;
	}
    
    
}
