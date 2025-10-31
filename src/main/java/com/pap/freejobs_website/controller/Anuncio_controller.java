package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.entity.Anuncio;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.Anuncio_servico;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/anuncio")
public class Anuncio_controller {

    @Autowired
    private Anuncio_servico anuncio_servico;

    @Autowired
    private Utilizador_servico utilizador_servico;

    // 🔍 Search anuncios by title
    @GetMapping("/pesquisa")
    public String buscarAnuncios(@RequestParam(value = "q", required = false) String termo, Model model) {

        List<Anuncio> resultados;

        if (termo != null && !termo.trim().isEmpty()) {
            // Se o termo existir, procura por título
            resultados = anuncio_servico.buscarPorTitulo(termo);
        } else {
            // Se o termo estiver vazio, mostra os 3 últimos anúncios
            resultados = anuncio_servico.buscarUltimos3();
            termo = null; // para o Thymeleaf saber que não há termo
        }

        // Converter as fotos em Base64 (se existirem)
        resultados.forEach(a -> {
            if (a.getFoto_anuncio() != null) {
                String fotoBase64 = Base64.getEncoder().encodeToString(a.getFoto_anuncio());
                a.setFotoAnuncioBase64(fotoBase64);
            }
        });

        model.addAttribute("resultados", resultados);
        model.addAttribute("termo", termo);

        return "pesquisa";
    }


    //ver anuncio
    @GetMapping("/{id}")
    public String verAnuncio(@PathVariable Long id, Model model) {
        Anuncio anuncio = anuncio_servico.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Anúncio não encontrado"));

        // Foto do anúncio
        if (anuncio.getFoto_anuncio() != null) {
            String fotoBase64 = Base64.getEncoder().encodeToString(anuncio.getFoto_anuncio());
            anuncio.setFotoAnuncioBase64(fotoBase64);
        }

        // Utilizador dono do anúncio
        Utilizador utilizador = anuncio.getUtilizador();

        // Foto de perfil do utilizador
        String fotoPerfilBase64 = null;
        if (utilizador.getFoto_de_perfil() != null) {
            fotoPerfilBase64 = Base64.getEncoder().encodeToString(utilizador.getFoto_de_perfil());
        }

        model.addAttribute("anuncio", anuncio);
        model.addAttribute("utilizador", utilizador);
        model.addAttribute("fotoPerfilBase64", fotoPerfilBase64);

        return "anuncio"; // o nome do ficheiro .html
    }


    //Excluir anuncio
    @PostMapping("/excluir/{id}")
    public String excluirAnuncio(@PathVariable Long id, Authentication authentication){
        Utilizador utilizador = utilizador_servico.findByEmail(authentication.getName());
        anuncio_servico.excluir_anuncio(id, utilizador);
        return "redirect:/meuperfil";
    }

}
