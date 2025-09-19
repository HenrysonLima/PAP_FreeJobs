package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.dto.Anuncio_dto;
import com.pap.freejobs_website.service.Anuncio_servico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/criaranuncio")
public class CriarAnuncio_controller {

    private final Anuncio_servico anuncio_servico;

    public CriarAnuncio_controller(Anuncio_servico anuncio_servico){
        this.anuncio_servico = anuncio_servico;
    }

    //Mostrar formulário HTML
    @GetMapping
    public String htmlCriarAnuncio(Model model){
        model.addAttribute("anuncio_dto", new Anuncio_dto());
        return "criar-anuncio";
    }

    //Salvar o utilizador na base de dados
    @PostMapping
    public String salvarAnuncio(@ModelAttribute("anuncio_dto") Anuncio_dto anuncio_dto, Model model){
        anuncio_servico.salvar_anuncio(anuncio_dto);
        return "redirect:/criaranuncio"; //query parameter
    }
}
