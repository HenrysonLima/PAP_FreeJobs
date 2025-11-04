package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.dto.*;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.ContactoDeUtilizador_servico;
import com.pap.freejobs_website.service.PerguntaDeSeguranca_servico;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/criarperfil")
public class CriarPerfil_controller {

    private final Utilizador_servico utilizador_servico;
    private final ContactoDeUtilizador_servico contactoDeUtilizador_servico;
    private final PerguntaDeSeguranca_servico perguntaDeSeguranca_servico;

    public CriarPerfil_controller(Utilizador_servico utilizador_servico, ContactoDeUtilizador_servico contactoDeUtilizador_servico, PerguntaDeSeguranca_servico perguntaDeSeguranca_servico){
        this.utilizador_servico = utilizador_servico;
        this.contactoDeUtilizador_servico = contactoDeUtilizador_servico;
        this.perguntaDeSeguranca_servico = perguntaDeSeguranca_servico;
    }

    //Mostra o formulário HTML
    @GetMapping
    public String htmlPerfil(Model model){

        //Inicialização dos objetos
        CriarPerfil_dto dto = new CriarPerfil_dto();
        dto.setUtilizador_dto(new Utilizador_dto());

        //Inicializar 4 objetos do wrapper de contacto
        ContactosWrapper_dto contactosWrapper_dto = new ContactosWrapper_dto();
        for (int i = 1 ; i <= 4 ; i++){
            ContactoDeUtilizador_dto contacto = new ContactoDeUtilizador_dto();
            contacto.setNivel_de_contacto(i); //inicializar nivel do contacto pelo iterador
            contactosWrapper_dto.getContactos().add(contacto);
        }
        dto.setContactos(contactosWrapper_dto);

        //Inicializar 3 perguntas de segurança
        List<PerguntaDeSeguranca_dto> perguntas = new ArrayList<>();
        for (int i = 1; i <= 3; i++){
            perguntas.add(new PerguntaDeSeguranca_dto());
        }
        dto.setPerguntasDeSeguranca(perguntas);

        model.addAttribute("criarPerfil_dto", dto);
        return "criar-perfil";
    }

    //Salvar o utilizador na base de dados
    @PostMapping
    public String criar_perfil(@ModelAttribute CriarPerfil_dto criarPerfil_dto, RedirectAttributes redirectAttributes){
        Utilizador_dto utilizador_dto = criarPerfil_dto.getUtilizador_dto();
        List<ContactoDeUtilizador_dto> contactos = criarPerfil_dto.getContactos().getContactos();

        try {
            Utilizador utilizadorSalvo = utilizador_servico.salvar_utilizador(utilizador_dto);
            contactoDeUtilizador_servico.salvar_contacto(contactos, utilizadorSalvo);
            perguntaDeSeguranca_servico.salvarPerguntas(criarPerfil_dto.getPerguntasDeSeguranca(), utilizadorSalvo);

            redirectAttributes.addFlashAttribute("sucessocriarperfil", true);
            return "redirect:/login";
        }
        catch (IllegalArgumentException e){
            redirectAttributes.addFlashAttribute("erroaocriarperfil", e.getMessage());
            return "redirect:/criarperfil";
        }
    }
}