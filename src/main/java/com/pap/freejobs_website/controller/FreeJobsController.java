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

    @GetMapping("/termoscondicoes")
    public String termoscondicoes(){ return "termos-condicoes"; }

    @GetMapping("/politicasprivacidade")
    public String politicasprivacidade(){ return "politicas-privacidade"; }

}