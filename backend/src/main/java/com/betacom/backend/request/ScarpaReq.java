package com.betacom.backend.request;

public class ScarpaReq {
	
	private Integer id;
	private Integer tagliaScarpe;
	private String chiusura;
	private String tipoScarpa;
	
	public ScarpaReq() {
	}

	public ScarpaReq(Integer id, Integer tagliaScarpe, String chiusura, String tipoScarpa) {
		this.id = id;
		this.tagliaScarpe = tagliaScarpe;
		this.chiusura = chiusura;
		this.tipoScarpa = tipoScarpa;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTagliaScarpe() {
		return tagliaScarpe;
	}

	public void setTagliaScarpe(Integer tagliaScarpe) {
		this.tagliaScarpe = tagliaScarpe;
	}

	public String getChiusura() {
		return chiusura;
	}

	public void setChiusura(String chiusura) {
		this.chiusura = chiusura;
	}

	public String getTipoScarpa() {
		return tipoScarpa;
	}

	public void setTipoScarpa(String tipoScarpa) {
		this.tipoScarpa = tipoScarpa;
	}
}
