package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.dto.Utilizador_dto;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;


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
    public String salvar_utilizador(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("senha") String senha,
            @RequestParam("foto_de_perfil") MultipartFile foto_de_perfil,
            @RequestParam("cv") MultipartFile cv
    ) {
        try {
            Utilizador_dto dto = new Utilizador_dto(username, email, senha, foto_de_perfil, cv);
            utilizador_servico.salvar_utilizador(dto);
            return "redirect:/criarperfil?sucesso"; //query parameter
        }
        catch (IllegalArgumentException e){

            return "redirect:https://www.youtube.com/shorts/2dJ5WGuG0nk";
        }
    }
}
