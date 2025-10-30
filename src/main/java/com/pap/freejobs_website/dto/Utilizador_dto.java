package com.pap.freejobs_website.dto;

import org.springframework.web.multipart.MultipartFile;


public class Utilizador_dto {

    private String username;
    private String email;
    private String senha;
    private MultipartFile foto_de_perfil;

    //Campo para o editar perfil
    private byte[] foto_de_perfil_bytes;

    private String usernameLowerCase;

    public Utilizador_dto(){}

    public Utilizador_dto(String username, String email, String senha) {
        this.username = username;
        this.email = email;
        this.senha = senha;
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

    public MultipartFile getFoto_de_perfil() {
        return foto_de_perfil;
    }

    public void setFoto_de_perfil(MultipartFile foto_de_perfil) {
        this.foto_de_perfil = foto_de_perfil;
    }

    //Campos para o editar perfil
    public byte[] getFoto_de_perfil_bytes() {
        return foto_de_perfil_bytes;
    }

    public void setFoto_de_perfil_bytes(byte[] foto_de_perfil_bytes) {
        this.foto_de_perfil_bytes = foto_de_perfil_bytes;
    }

    public String getUsernameLowerCase() {
        return usernameLowerCase;
    }

    public void setUsernameLowerCase(String usernameLowerCase) {
        this.usernameLowerCase = usernameLowerCase;
    }
}
