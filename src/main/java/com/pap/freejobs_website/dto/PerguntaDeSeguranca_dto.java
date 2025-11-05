package com.pap.freejobs_website.dto;

import com.pap.freejobs_website.entity.PerguntaDeSeguranca;

public class PerguntaDeSeguranca_dto {
    private String pergunta;
    private String resposta;

    public PerguntaDeSeguranca_dto() {}

    //construtor para o recuperar senha
    public PerguntaDeSeguranca_dto(PerguntaDeSeguranca entity){
        this.pergunta = entity.getPergunta();
        this.resposta = "";
    }

    //Getters e Setters
    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}