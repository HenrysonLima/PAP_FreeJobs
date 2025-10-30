package com.pap.freejobs_website.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Lob
    private byte[] foto_de_perfil;

    //para encontrar o utilizador ignorando lowercases
    @Column(nullable = false, unique = true)
    private String usernameLowerCase;

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.ALL)
    private List<Anuncio> anuncios = new ArrayList<>();

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactoDeUtilizador> contactosDeUtilizador = new ArrayList<>();

    //Contrutores
    public Utilizador() {}

    public Utilizador(String username, String email, String senha) {
        this.username = username;
        this.email = email;
        this.senha = senha;
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

    public byte[] getFoto_de_perfil() {
        return foto_de_perfil;
    }

    public void setFoto_de_perfil(byte[] foto_de_perfil) {
        this.foto_de_perfil = foto_de_perfil;
    }

    public String getUsernameLowerCase() {
        return usernameLowerCase;
    }

    public void setUsernameLowerCase(String usernameLowerCase) {
        this.usernameLowerCase = usernameLowerCase;
    }

    public List<ContactoDeUtilizador> getContactosDeUtilizador() {
        return contactosDeUtilizador;
    }

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }
}
