package com.pap.freejobs_website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anuncio")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome_do_anuncio;

    @Lob
    private byte[] foto_anuncio;

    @Column(nullable = false)
    private Float preco;

    @Column()
    private String descricao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilizador_id", nullable = false)
    private Utilizador utilizador;

    //Construtores
    public Anuncio(){}

    public Anuncio(String nome_do_anuncio, byte[] foto_anuncio, float preco, String descricao, Utilizador utilizador){
        this.nome_do_anuncio = nome_do_anuncio;
        this.foto_anuncio = foto_anuncio;
        this.preco = preco;
        this.descricao = descricao;
        this.utilizador = utilizador;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

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

    public void setPreco(float preco_em_centavos) {
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