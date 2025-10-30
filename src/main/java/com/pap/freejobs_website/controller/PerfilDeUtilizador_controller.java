package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Base64;

@Controller
public class PerfilDeUtilizador_controller {

    @Autowired
    private Utilizador_servico utilizador_servico;

    @GetMapping("/perfil/{usernameLowerCase}")
    public String verPerfilDeOutroUtilizador(@PathVariable String usernameLowerCase, Model model){

        Utilizador utilizador = utilizador_servico.findByUsernameLowerCase(usernameLowerCase);

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

        return "perfil-de-utilizador";
    }

}
