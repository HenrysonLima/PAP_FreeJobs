package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.dto.Utilizador_dto;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/criarperfil")
public class Utilizador_controller {

    private final Utilizador_servico utilizador_servico;

    public Utilizador_controller(Utilizador_servico utilizador_servico){
        this.utilizador_servico = utilizador_servico;
    }

    //Mostra o formulário HTML
    @GetMapping
    public String htmlPerfil(Model model){
        model.addAttribute("utilizador_dto", new Utilizador_dto());
        return "criar-perfil";
    }

    //Salvar o utilizador na base de dados
    @PostMapping
    public String salvar_utilizador(@ModelAttribute("utilizador_dto") Utilizador_dto utilizador_dto, Model model){
        try {
            utilizador_servico.salvar_utilizador(utilizador_dto);
            return "redirect:/criarperfil?sucesso"; //query parameter
        }
        catch (IllegalArgumentException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "redirect:/criarperfil?erroaocriarperfil"; //mudar posteriormente
        }
    }
}
