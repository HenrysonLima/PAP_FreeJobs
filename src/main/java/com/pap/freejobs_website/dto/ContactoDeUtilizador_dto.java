package com.pap.freejobs_website.dto;

import com.pap.freejobs_website.entity.Utilizador;

public class ContactoDeUtilizador_dto {
    private String forma_de_contacto;
    private int nivel_de_contacto;
    private String contacto;
    private Utilizador utilizador;

    //Construtores
    public ContactoDeUtilizador_dto(){}

    public ContactoDeUtilizador_dto(String forma_de_contacto, int nivel_de_contacto, String contacto, Utilizador utilizador){
        this.forma_de_contacto = forma_de_contacto;
        this.nivel_de_contacto = nivel_de_contacto;
        this.contacto = contacto;
        this.utilizador = utilizador;
    }

    //Getters and setters
    public String getForma_de_contacto() {
        return forma_de_contacto;
    }

    public void setForma_de_contacto(String forma_de_contacto) {
        this.forma_de_contacto = forma_de_contacto;
    }

    public int getNivel_de_contacto() {
        return nivel_de_contacto;
    }

    public void setNivel_de_contacto(int nivel_de_contacto) {
        this.nivel_de_contacto = nivel_de_contacto;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}