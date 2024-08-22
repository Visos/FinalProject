package com.betacom.backend.dto;

import java.util.List;


public class ColoreDTO {

	private Integer id;
	private String desc;
	private List<ProdottoDTO> prodotto;
	
	public ColoreDTO() {
		super();
	}

	public ColoreDTO(Integer id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}
	
	public ColoreDTO(Integer id, String desc, List<ProdottoDTO> prodotto) {
		super();
		this.id = id;
		this.desc = desc;
		this.prodotto = prodotto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<ProdottoDTO> getVeicoli() {
		return prodotto;
	}

	public void setVeicoli(List<ProdottoDTO> prodotto) {
		this.prodotto = prodotto;
	}

	@Override
	public String toString() {
		return "ColoreDTO [id=" + id + ", desc=" + desc + ", prodotto=" + prodotto + "]";
	}
	
	
}
