package com.pap.freejobs_website.dto;

import java.util.HashMap;
import java.util.Map;

public class CriarPerfil_dto {
    private Utilizador_dto utilizador_dto;
    private ContactosWrapper_dto contactos;
    private Map<String, String> perguntasDeSeguranca = new HashMap<>();

    public CriarPerfil_dto(){
        //prevenir null pointers inicializando os campos
        this.utilizador_dto = new Utilizador_dto();
        this.contactos = new ContactosWrapper_dto();

        // inicializar as perguntas de segurança com chaves padrão
        perguntasDeSeguranca.put("Qual é o nome do seu primeiro animal de estimação?", "");
        perguntasDeSeguranca.put("Qual é a sua cidade natal?", "");
        perguntasDeSeguranca.put("Qual é o nome da sua escola primária?", "");
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

    public Map<String, String> getPerguntasDeSeguranca() {
        return perguntasDeSeguranca;
    }

    public void setPerguntasDeSeguranca(Map<String, String> perguntasDeSeguranca) {
        this.perguntasDeSeguranca = perguntasDeSeguranca;
    }
}
