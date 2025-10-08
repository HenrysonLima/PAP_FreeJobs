package com.pap.freejobs_website.dto;

import org.springframework.web.multipart.MultipartFile;


public class Utilizador_dto {

    private String username;
    private String email;
    private String senha;
    private MultipartFile foto_de_perfil;
    private MultipartFile cv;

    //Campos para o editar perfil
    private byte[] foto_de_perfil_bytes;
    private byte[] cv_bytes;

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

    public MultipartFile getCv() {
        return cv;
    }

    public void setCv(MultipartFile cv) {
        this.cv = cv;
    }

    //Campos para o editar perfil
    public byte[] getFoto_de_perfil_bytes() {
        return foto_de_perfil_bytes;
    }

    public void setFoto_de_perfil_bytes(byte[] foto_de_perfil_bytes) {
        this.foto_de_perfil_bytes = foto_de_perfil_bytes;
    }

    public byte[] getCv_bytes() {
        return cv_bytes;
    }

    public void setCv_bytes(byte[] cv_bytes) {
        this.cv_bytes = cv_bytes;
    }
}
