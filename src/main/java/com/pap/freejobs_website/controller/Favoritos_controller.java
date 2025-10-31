package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.entity.Anuncio;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.Favoritos_servico;
import com.pap.freejobs_website.service.Utilizador_servico;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/favoritos")
public class Favoritos_controller {

    @Autowired
    private Favoritos_servico favoritos_servico;

    @Autowired
    private Utilizador_servico utilizadorServico;

    @PostMapping("/adicionar/{anuncioId}")
    public String adicionarFavorito(@PathVariable Long anuncioId, Authentication authentication, RedirectAttributes redirectAttributes) {
        Utilizador utilizador = utilizadorServico.findByEmail(authentication.getName());
        favoritos_servico.adicionarFavorito(anuncioId, utilizador);

        redirectAttributes.addFlashAttribute("sucessoAdicionarFavorito", true);
        return "redirect:/anuncio/" + anuncioId;
    }

    @PostMapping("/remover/{anuncioId}")
    public String removerFavorito(@PathVariable Long anuncioId, Authentication authentication, HttpServletRequest request) {
        Utilizador utilizador = utilizadorServico.findByEmail(authentication.getName());
        favoritos_servico.removerFavorito(anuncioId, utilizador);

        // Redireciona utilizador para a ultima página que ele estava
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "/meuperfil");
    }

    @GetMapping
    public String verFavoritos(Authentication authentication, Model model) {
        Utilizador utilizador = utilizadorServico.findByEmail(authentication.getName());
        List<Anuncio> favoritos = favoritos_servico.listarFavoritos(utilizador);

        favoritos.forEach(a -> {
            if (a.getFoto_anuncio() != null) {
                String fotoBase64 = Base64.getEncoder().encodeToString(a.getFoto_anuncio());
                a.setFotoAnuncioBase64(fotoBase64);
            }
        });

        model.addAttribute("favoritos", favoritos);
        return "favoritos";
    }
}
