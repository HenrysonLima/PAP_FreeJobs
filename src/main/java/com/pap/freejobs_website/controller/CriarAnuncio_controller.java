package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.Security.CustomUserDetails;
import com.pap.freejobs_website.dto.Anuncio_dto;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.Utilizador_repositorio;
import com.pap.freejobs_website.service.Anuncio_servico;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/criaranuncio")
public class CriarAnuncio_controller {

    private final Anuncio_servico anuncio_servico;
    private final Utilizador_repositorio utilizadorRepositorio;

    public CriarAnuncio_controller(Anuncio_servico anuncio_servico, Utilizador_repositorio utilizadorRepositorio){
        this.anuncio_servico = anuncio_servico;
        this.utilizadorRepositorio = utilizadorRepositorio;
    }

    //Mostrar formulário HTML
    @GetMapping
    public String htmlCriarAnuncio(Model model){
        model.addAttribute("anuncio_dto", new Anuncio_dto());
        return "criar-anuncio";
    }

    //Salvar o anuncio na base de dados
    @PostMapping
    public String salvarAnuncio(@ModelAttribute("anuncio_dto") Anuncio_dto anuncio_dto,
                                @AuthenticationPrincipal CustomUserDetails userDetails,
                                RedirectAttributes redirectAttributes){

        //buscar username do utilizador logado
        Long IdUtilizador = userDetails.getId();

        //buscar entidade do utilizador na base de dados
        Utilizador utilizador = utilizadorRepositorio.findById(IdUtilizador)
                        .orElseThrow(() -> new RuntimeException("Utilizador nao encontrado"));

        // associar utilizador com anuncio
        anuncio_dto.setUtilizador(utilizador);

        // salvar anuncio
        anuncio_servico.salvar_anuncio(anuncio_dto);

        redirectAttributes.addFlashAttribute("anunciocriado" , true);
        return "redirect:/meuperfil";
    }
}
