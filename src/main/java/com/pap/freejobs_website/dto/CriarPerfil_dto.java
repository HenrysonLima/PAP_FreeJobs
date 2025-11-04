package com.pap.freejobs_website.dto;

import java.util.ArrayList;
import java.util.List;

public class CriarPerfil_dto {
    private Utilizador_dto utilizador_dto;
    private ContactosWrapper_dto contactos;
    private List<PerguntaDeSeguranca_dto> perguntasDeSeguranca;

    public CriarPerfil_dto(){
        //prevenir null pointers inicializando os campos
        this.utilizador_dto = new Utilizador_dto();
        this.contactos = new ContactosWrapper_dto();
        this.perguntasDeSeguranca = new ArrayList<>();

    }

    public Utilizador_dto getUtilizador_dto() {
        return utilizador_dto;
    }

    public void setUtilizador_dto(Utilizador_dto utilizador_dto) {
        this.utilizador_dto = utilizador_dto;
    }

    public ContactosWrapper_dto getContactos() {
        return contactos;
    }

    public void setContactos(ContactosWrapper_dto contactos) {
        this.contactos = contactos;
    }

    public List<PerguntaDeSeguranca_dto> getPerguntasDeSeguranca() {
        return perguntasDeSeguranca;
    }

    public void setPerguntasDeSeguranca(List<PerguntaDeSeguranca_dto> perguntasDeSeguranca) {
        this.perguntasDeSeguranca = perguntasDeSeguranca;
    }
}
