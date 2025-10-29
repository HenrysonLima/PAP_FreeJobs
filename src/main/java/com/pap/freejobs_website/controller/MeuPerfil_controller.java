package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Base64;

@Controller
public class MeuPerfil_controller {

    @Autowired
    private Utilizador_servico utilizador_servico;

    @GetMapping("/meuperfil")
    public String verPerfil(Authentication authentication, Model model) {

        String emailUtilizador = authentication.getName(); //puxar email do utilizador logado
        Utilizador utilizador = utilizador_servico.findByEmail(emailUtilizador);

        // converte foto de perfil se existente
        if(utilizador.getFoto_de_perfil() != null){
            String fotoBase64 = Base64.getEncoder().encodeToString(utilizador.getFoto_de_perfil());
            model.addAttribute("fotoBase64", fotoBase64);
        }

        // converte imagens dos anuncios se existentes
        utilizador.getAnuncios().forEach(a -> {
            if (a.getFoto_anuncio() != null){
                String fotoAnuncioBase64 = Base64.getEncoder().encodeToString(a.getFoto_anuncio());
                a.setFotoAnuncioBase64(fotoAnuncioBase64); // adiciona um transient field para a view
            }
        });

        //criar atributos para o thymeleaf
        model.addAttribute("utilizador", utilizador);
        model.addAttribute("contactos", utilizador.getContactosDeUtilizador());
        model.addAttribute("anuncios", utilizador.getAnuncios());

        return "meu-perfil";
    }

}