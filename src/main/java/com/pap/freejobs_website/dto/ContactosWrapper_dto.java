package com.pap.freejobs_website.dto;

import java.util.ArrayList;
import java.util.List;

//para o uso de diversos objetos vindos do mesmo formulário
public class ContactosWrapper_dto {
    private List<ContactoDeUtilizador_dto> contactos= new ArrayList<>();

    //getters and setters
    public List<ContactoDeUtilizador_dto> getContactos() {
        return contactos;
    }

    public void setContactos(List<ContactoDeUtilizador_dto> contactos) {
        this.contactos = contactos;
    }
}
