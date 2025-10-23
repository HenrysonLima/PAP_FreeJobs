package com.pap.freejobs_website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anuncio")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Lob
    private byte[] foto_anuncio;

    @Column(nullable = false)
    private Float preco;

    @Column(length = 500)
    private String descricao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilizador_id", nullable = false)
    private Utilizador utilizador;

    @Transient //faz com que o JPA não salve o campo na base de dados
    private String fotoAnuncioBase64;

    //Construtores
    public Anuncio(){}

    public Anuncio(String titulo, byte[] foto_anuncio, float preco, String descricao, Utilizador utilizador){
        this.titulo = titulo;
        this.foto_anuncio = foto_anuncio;
        this.preco = preco;
        this.descricao = descricao;
        this.utilizador = utilizador;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getFotoAnuncioBase64() {
        return fotoAnuncioBase64;
    }

    public void setFotoAnuncioBase64(String fotoAnuncioBase64) {
        this.fotoAnuncioBase64 = fotoAnuncioBase64;
    }
}