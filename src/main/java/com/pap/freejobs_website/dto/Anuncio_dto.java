package com.pap.freejobs_website.dto;

import com.pap.freejobs_website.entity.Utilizador;
import org.springframework.web.multipart.MultipartFile;

public class Anuncio_dto {
    private String nome_do_anuncio;
    private MultipartFile foto_anuncio;
    private Float preco;
    private String descricao;
    private Utilizador utilizador;

    //Construtores
    public Anuncio_dto(){}

    public Anuncio_dto(String nome_do_anuncio, MultipartFile foto_anuncio, Float preco, String descricao, Utilizador utilizador){
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

    public MultipartFile getFoto_anuncio() {
        return foto_anuncio;
    }

    public void setFoto_anuncio(MultipartFile foto_anuncio) {
        this.foto_anuncio = foto_anuncio;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
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