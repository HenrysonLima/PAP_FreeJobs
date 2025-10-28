package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.dto.ContactoFeito_dto;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.ContactoFeito_servico;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contacto")
public class ContactoFeito_controller {

    @Autowired
    private ContactoFeito_servico contactoFeito_servico;

    @Autowired
    private Utilizador_servico utilizador_servico;

    @GetMapping
    public String verPaginaDeContacto(Model model){
        ContactoFeito_dto contactoFeito_dto = new ContactoFeito_dto();
        model.addAttribute("contactoFeito_dto", contactoFeito_dto);
        return "contacto";
    }

    @PostMapping
    public String enviarMensagem(ContactoFeito_dto contactoFeito_dto, Authentication authentication, RedirectAttributes redirectAttributes){

        //verificação para saber se o utilizador está ou não autenticado
        if(authentication != null && authentication.isAuthenticated()){

            //contacto com utilizador autenticado
            Utilizador utilizador = utilizador_servico.findByEmail(authentication.getName());
            contactoFeito_servico.salvar_contactoFeito_autenticado(contactoFeito_dto, utilizador);
            contactoFeito_servico.enviarEmail_autenticado(contactoFeito_dto, utilizador);

        }
        else{

            //contacto com utilizador não autenticado
            contactoFeito_servico.salvar_contactoFeito_naoAutenticado(contactoFeito_dto);
            contactoFeito_servico.enviarEmail_naoAutenticado(contactoFeito_dto);

        }

        redirectAttributes.addFlashAttribute("contactoFeitoComSucesso", true);
        return "redirect:/";
    }

}