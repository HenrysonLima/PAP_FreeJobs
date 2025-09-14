package com.pap.freejobs_website.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeJobsController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/criaranuncio")
    public String criarAnuncio(){
        return "criar-anuncio";
    }

    @GetMapping("/perfil")
    public String perfil(){ return "perfil";}

    @GetMapping("/criarperfil")
    public String criarPerfil(){ return "criar-perfil"; }

    @GetMapping("/anuncio")
    public String anuncio(){ return "anuncio"; }

    @GetMapping("/pesquisa")
    public String pesquisa(){ return "pesquisa"; }

    @GetMapping("/contacto")
    public String contacto(){ return "contacto"; }

}