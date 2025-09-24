package com.pap.freejobs_website.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FreeJobsController {

    @GetMapping("/")
    public String home(Authentication authentication){
        return "index";
    }

    @GetMapping("/login")
    public String login(Authentication authentication){
        //Se utilizador estiver logado, é redirecionado para homepage
        if(authentication != null && authentication.isAuthenticated()){
            return "redirect:/";
        }
        return "login";
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