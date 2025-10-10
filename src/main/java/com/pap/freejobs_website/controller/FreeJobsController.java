package com.pap.freejobs_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeJobsController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(){ return "perfil";}

    @GetMapping("/meuperfil")
    public String meuPerfil(){ return "meu-perfil"; }

    @GetMapping("/anuncio")
    public String anuncio(){ return "anuncio"; }

    @GetMapping("/pesquisa")
    public String pesquisa(){ return "pesquisa"; }

    @GetMapping("/contacto")
    public String contacto(){ return "contacto"; }

}