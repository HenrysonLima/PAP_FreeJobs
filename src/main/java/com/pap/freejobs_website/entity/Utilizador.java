package com.pap.freejobs_website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizador")
public class Utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @Column(nullable = false, unique = true)
    private String url_foto_de_perfil;

    @Column(nullable = false, unique = true)
    private String url_CV;

    //Contrutores
    public Utilizador() {}

    public Utilizador(String username, String email, String senha, String url_foto_de_perfil, String url_CV) {
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.url_foto_de_perfil = url_foto_de_perfil;
        this.url_CV = url_CV;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUrl_foto_de_perfil() {
        return url_foto_de_perfil;
    }

    public void setUrl_foto_de_perfil(String url_foto_de_perfil) {
        this.url_foto_de_perfil = url_foto_de_perfil;
    }

    public String getUrl_CV() {
        return url_CV;
    }

    public void setUrl_CV(String url_CV) {
        this.url_CV = url_CV;
    }
}
