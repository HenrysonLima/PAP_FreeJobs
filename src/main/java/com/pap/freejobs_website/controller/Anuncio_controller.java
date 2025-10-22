package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.entity.Anuncio;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.Anuncio_servico;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;

@Controller
@RequestMapping("/anuncio")
public class Anuncio_controller {

    @Autowired
    private Anuncio_servico anuncio_servico;

    @Autowired
    private Utilizador_servico utilizador_servico;

    //ver anuncio
    @GetMapping("/{id}")
    public String verAnuncio(@PathVariable Long id, Model model){
        Anuncio anuncio = anuncio_servico.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Anuncio não encontrado"));

        if (anuncio.getFoto_anuncio() != null){
            String fotoBase64 = Base64.getEncoder().encodeToString(anuncio.getFoto_anuncio());

        }

        model.addAttribute("anuncio",anuncio);
        return "anuncio";
    }

    //Excluir anuncio
    @PostMapping("/excluir/{id}")
    public String excluirAnuncio(@PathVariable Long id, Authentication authentication){
        Utilizador utilizador = utilizador_servico.findByEmail(authentication.getName());
        anuncio_servico.excluir_anuncio(id, utilizador);
        return "redirect:/meuperfil";
    }

}
