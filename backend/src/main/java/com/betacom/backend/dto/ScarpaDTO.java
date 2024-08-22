package com.betacom.backend.dto;

public class ScarpaDTO {
	
	private Integer id;
	private Integer tagliaScarpe;
	private String chiusura;
	private String tipoScarpa;
	
	public ScarpaDTO(Integer id, Integer tagliaScarpe, String chiusura, String tipoScarpa) {
		super();
		this.id = id;
		this.tagliaScarpe = tagliaScarpe;
		this.chiusura = chiusura;
		this.tipoScarpa = tipoScarpa;
	}
	
	public ScarpaDTO() {
		super();
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
