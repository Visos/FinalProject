package com.betacom.backend.request;

public class UtenteReq {

    private Integer id;
    private String nome;
    private String cognome;
    private String mail;
    private String password;
    private String ruolo;
    private String paese;
    private String strada;
    private String civico;
    private Integer cap;

    public UtenteReq() {
    }

    public UtenteReq(Integer id, String nome, String cognome, String mail, String password, String ruolo, String paese,
            String strada, String civico, Integer cap) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.password = password;
        this.ruolo = ruolo;
        this.paese = paese;
        this.strada = strada;
        this.civico = civico;
        this.cap = cap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }
}
