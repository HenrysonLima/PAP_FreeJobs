package com.pap.freejobs_website.dto;

public class ContactoFeito_dto {

    private String assunto;
    private String mensagem;
    private String emailNaoAutenticado;

    //construtores
    public ContactoFeito_dto(){}

    //Getters and Setters
    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getEmailNaoAutenticado() {
        return emailNaoAutenticado;
    }

    public void setEmailNaoAutenticado(String emailNaoAutenticado) {
        this.emailNaoAutenticado = emailNaoAutenticado;
    }
}
