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
    private int preco_em_centavos;

    @Column()
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "utilizador_id", nullable = false)
    private Utilizador utilizador;

    //Construtores
    public Anuncio(){}

    public Anuncio(String nome_do_anuncio, byte[] foto_anuncio, int preco_em_centavos, String descricao, Utilizador utilizador){
        this.nome_do_anuncio = nome_do_anuncio;
        this.foto_anuncio = foto_anuncio;
        this.preco_em_centavos = preco_em_centavos;
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

    public int getPreco_em_centavos() {
        return preco_em_centavos;
    }

    public void setPreco_em_centavos(int preco_em_centavos) {
        this.preco_em_centavos = preco_em_centavos;
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