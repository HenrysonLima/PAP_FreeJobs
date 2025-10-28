package com.pap.freejobs_website.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "contacto_feito")
public class ContactoFeito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assunto;

    @Column(nullable = false, length = 5000)
    private String mensagem;

    @Column(nullable = false)
    private LocalDateTime dataDoContacto;

    @ManyToOne(optional = true)
    @JoinColumn(name = "utilizador", nullable = true)
    private Utilizador utilizador;

    //campos opcionais caso utilizador não esteja com login
    @Column(nullable = true)
    private String emailNaoAutenticado;

    //construtores
    public ContactoFeito(){}

    //contrutor não autenticado
    public ContactoFeito(String assunto, String mensagem, LocalDateTime dataDoContacto, String emailNaoAutenticado){
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.dataDoContacto = dataDoContacto;
        this.emailNaoAutenticado = emailNaoAutenticado;
    }

    //construtor autenticado
    public ContactoFeito(String assunto, String mensagem, LocalDateTime dataDoContacto, Utilizador utilizador ){
        this.assunto = assunto;
        this.mensagem = mensagem;
        this.dataDoContacto = dataDoContacto;
        this.utilizador = utilizador;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public LocalDateTime getDataDoContacto() {
        return dataDoContacto;
    }

    public void setDataDoContacto(LocalDateTime dataDoContacto) {
        this.dataDoContacto = dataDoContacto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public String getEmailNaoAutenticado() {
        return emailNaoAutenticado;
    }

    public void setEmailNaoAutenticado(String emailNaoAutenticado) {
        this.emailNaoAutenticado = emailNaoAutenticado;
    }

}
