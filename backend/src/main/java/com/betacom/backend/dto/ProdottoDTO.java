package com.betacom.backend.dto;

import java.util.List;

public class ProdottoDTO {
	
	  private Integer id;
	  private Integer qty;
	  private String sesso;
	  private String colore;
	  private String marca;
	  private String materiale;
	  private String fantasia;
	  private MagliettaDTO magliettaDto;
	  private PantaloneDTO pantaloneDto;
	  private VestitoDTO vestitoDto;
	  private ScarpaDTO scarpaDto;
	  private CamiciaDTO camiciaDto;
	  private Integer prezzo;
	  private List<ProdottiOrdiniDTO> listProdOrdiniDto;
	
	
	  public ProdottoDTO() {
		super();
	}
	public ProdottoDTO(Integer id, Integer qty, String sesso, String colore, String marca, String materiale,
			String fantasia, MagliettaDTO magliettaDto, PantaloneDTO pantaloneDto, VestitoDTO vestitoDto,
			ScarpaDTO scarpaDto, CamiciaDTO camiciaDto, Integer prezzo) {
		super();
		this.id = id;
		this.qty = qty;
		this.sesso = sesso;
		this.colore = colore;
		this.marca = marca;
		this.materiale = materiale;
		this.fantasia = fantasia;
		this.magliettaDto = magliettaDto;
		this.pantaloneDto = pantaloneDto;
		this.vestitoDto = vestitoDto;
		this.scarpaDto = scarpaDto;
		this.camiciaDto = camiciaDto;
		this.prezzo = prezzo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMateriale() {
		return materiale;
	}
	public void setMateriale(String materiale) {
		this.materiale = materiale;
	}
	public String getFantasia() {
		return fantasia;
	}
	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}
	public MagliettaDTO getMagliettaDto() {
		return magliettaDto;
	}
	public void setMagliettaDto(MagliettaDTO magliettaDto) {
		this.magliettaDto = magliettaDto;
	}
	public PantaloneDTO getPantaloneDto() {
		return pantaloneDto;
	}
	public void setPantaloneDto(PantaloneDTO pantaloneDto) {
		this.pantaloneDto = pantaloneDto;
	}
	public VestitoDTO getVestitoDto() {
		return vestitoDto;
	}
	public void setVestitoDto(VestitoDTO vestitoDto) {
		this.vestitoDto = vestitoDto;
	}
	public ScarpaDTO getScarpaDto() {
		return scarpaDto;
	}
	public void setScarpaDto(ScarpaDTO scarpaDto) {
		this.scarpaDto = scarpaDto;
	}
	public CamiciaDTO getCamiciaDto() {
		return camiciaDto;
	}
	public void setCamiciaDto(CamiciaDTO camiciaDto) {
		this.camiciaDto = camiciaDto;
	}
	public Integer getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}
	public List<ProdottiOrdiniDTO> getListProdOrdiniDto() {
		return listProdOrdiniDto;
	}
	public void setListProdOrdiniDto(List<ProdottiOrdiniDTO> listProdOrdiniDto) {
		this.listProdOrdiniDto = listProdOrdiniDto;
	}
	  
	  
}
