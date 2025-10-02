package com.pap.freejobs_website.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Contacto_de_utilizador")
public class ContactoDeUtilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String forma_de_contacto;

    @Column(nullable = false, length = 1)
    private int nivel_de_contacto;

    @Column(nullable = false, length = 100)
    private String contacto;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilizador_id")
    private Utilizador utilizador;

    //Construtores
    public ContactoDeUtilizador(){}

    public ContactoDeUtilizador(String forma_de_contacto, int nivel_de_contacto, String contacto, Utilizador utilizador){
        this.forma_de_contacto = forma_de_contacto;
        this.nivel_de_contacto = nivel_de_contacto;
        this.contacto = contacto;
        this.utilizador = utilizador;
    }

    //Getters and setters
    public Long getId() {   return id;    }

    public String getForma_de_contacto() {
        return forma_de_contacto;
    }

    public void setForma_de_contacto(String forma_de_contacto) {
        this.forma_de_contacto = forma_de_contacto;
    }

    public int getNivel_de_contacto() {
        return nivel_de_contacto;
    }

    public void setNivel_de_contacto(int nivel_de_contacto) {
        this.nivel_de_contacto = nivel_de_contacto;
    }

    public String getContacto() {   return contacto;    }

    public void setContacto(String contacto) {  this.contacto = contacto;   }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}
