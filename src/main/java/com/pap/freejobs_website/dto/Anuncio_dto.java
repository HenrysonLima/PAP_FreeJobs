package com.pap.freejobs_website.dto;

import com.pap.freejobs_website.entity.Utilizador;

public class Anuncio_dto {
    private String nome_do_anuncio;
    private byte[] foto_anuncio;
    private float preco;
    private String descricao;
    private Utilizador utilizador;

    //Construtores
    public Anuncio_dto(){}

    public Anuncio_dto(String nome_do_anuncio, byte[] foto_anuncio, float preco, String descricao, Utilizador utilizador){
        this.nome_do_anuncio = nome_do_anuncio;
        this.foto_anuncio = foto_anuncio;
        this.preco = preco;
        this.descricao = descricao;
        this.utilizador = utilizador;
    }

    //Getters and Setters
    public String getNome_do_anuncio() {
        return nome_do_anuncio;
    }

    public void setNome_do_anuncio(String nome_do_anuncio) {
        this.nome_do_anuncio = nome_do_anuncio;
    }

    public byte[] getFoto_anuncio() {
        return foto_anuncio;
    }

    public void setFoto_anuncio(byte[] foto_anuncio) {
        this.foto_anuncio = foto_anuncio;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}