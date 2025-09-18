package com.pap.freejobs_website.dto;

public class Utilizador_dto {
    private String username;
    private String email;
    private String senha;
    private String url_foto_de_perfil;
    private String url_CV;

    public Utilizador_dto(){}

    public Utilizador_dto(String username, String email, String senha, String url_foto_de_perfil, String url_CV) {
        this.username = username;
        this.email = email;
        this.senha = senha;
        this.url_foto_de_perfil = url_foto_de_perfil;
        this.url_CV = url_CV;
    }

    //Getters and Setters
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
