package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.entity.Anuncio;
import com.pap.freejobs_website.service.Anuncio_servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Base64;
import java.util.List;

@Controller
public class FreeJobsController {

    @Autowired
    private Anuncio_servico anuncio_servico;

    //homepage
    @GetMapping("/")
    public String home(Model model){
        List<Anuncio> anunciosRecentes;

        anunciosRecentes = anuncio_servico.buscarUltimos3();

        // Converter as fotos em Base64 (se existirem)
        anunciosRecentes.forEach(a -> {
            if (a.getFoto_anuncio() != null) {
                String fotoBase64 = Base64.getEncoder().encodeToString(a.getFoto_anuncio());
                a.setFotoAnuncioBase64(fotoBase64);
            }
        });

        model.addAttribute("anunciosRecentes", anunciosRecentes );

        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(){ return "perfil";}

    @GetMapping("/termoscondicoes")
    public String termoscondicoes(){ return "termos-condicoes"; }

    @GetMapping("/politicasprivacidade")
    public String politicasprivacidade(){ return "politicas-privacidade"; }

}