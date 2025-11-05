package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.dto.PerguntaDeSeguranca_dto;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.PerguntaDeSeguranca_servico;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/recuperarsenha")
public class RecuperarSenha_controller {

    private final Utilizador_servico utilizador_servico;
    private final PerguntaDeSeguranca_servico perguntaDeSeguranca_servico;

    public RecuperarSenha_controller(Utilizador_servico utilizador_servico, PerguntaDeSeguranca_servico perguntaDeSeguranca_servico){
        this.utilizador_servico =  utilizador_servico;
        this.perguntaDeSeguranca_servico = perguntaDeSeguranca_servico;
    }

    //pagina para inserir email
    @GetMapping
    public String verPaginaEmail(){
        return "recuperar-senha-email";
    }

    //carregar perguntas do utilizador
    @PostMapping("/verificar")
    public String verificarEmail(@RequestParam("email") String email, Model model, RedirectAttributes redirectAttributes) {
        Utilizador utilizador;

        try {
            utilizador = utilizador_servico.findByEmail(email);
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("erroAoEncontrarEmail", "Nenhum utilizador encontrado com esse email.");
            return "redirect:/recuperarsenha";
        }

        //buscar perguntas do utilizador
        List<PerguntaDeSeguranca_dto> perguntas = perguntaDeSeguranca_servico.buscarPerguntasDoUtilizador(utilizador);

        if (perguntas.isEmpty()) {
            redirectAttributes.addFlashAttribute("erroUtilizadorSemPerguntas", "Este utilizador não possui perguntas de segurança.");
            return "redirect:/recuperarsenha";
        }

        model.addAttribute("utilizadorEmail", email);
        model.addAttribute("perguntas", perguntas);
        return "recuperar-senha";
    }


    //validar respostas e atualizar senha
    @PostMapping("/atualizar")
    public String atualizarSenha(@RequestParam("email") String email,
                                 @RequestParam("respostas") List<String> respostas,
                                 @RequestParam("novaSenha") String novaSenha,
                                 RedirectAttributes redirectAttributes) {

        try {
            perguntaDeSeguranca_servico.validarRespostasEAtualizarSenha(email, respostas, novaSenha);
            redirectAttributes.addFlashAttribute("sucessoRecuperarSenha", "Senha atualizada com sucesso!");
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("erroRecuperarSenha", "Alguma resposta não está correta");
            return "redirect:/recuperarsenha";
        }
    }

}
