package com.pap.freejobs_website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "perguntas_de_seguranca")
public class PerguntaDeSeguranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String pergunta;

    @Column(nullable = false, length = 100)
    private String resposta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilizador_id", nullable = false)
    private Utilizador utilizador;

    //construtores
    public PerguntaDeSeguranca (){}

    public PerguntaDeSeguranca(String pergunta, String resposta, Utilizador utilizador){
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.utilizador = utilizador;
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}
