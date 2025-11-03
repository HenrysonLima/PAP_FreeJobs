package com.pap.freejobs_website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recuperarsenha")
public class RecuperarSenha_controller {

    @GetMapping
    public String verPaginaRecuperarSenha(){
        return "recuperar-senha";
    }
}
