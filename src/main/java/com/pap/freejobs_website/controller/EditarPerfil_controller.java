package com.pap.freejobs_website.controller;

import com.pap.freejobs_website.dto.ContactoDeUtilizador_dto;
import com.pap.freejobs_website.dto.ContactosWrapper_dto;
import com.pap.freejobs_website.dto.CriarPerfil_dto;
import com.pap.freejobs_website.dto.Utilizador_dto;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.service.ContactoDeUtilizador_servico;
import com.pap.freejobs_website.service.Utilizador_servico;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/editarperfil")
public class EditarPerfil_controller {

    private final Utilizador_servico utilizador_servico;
    private final ContactoDeUtilizador_servico contactoDeUtilizador_servico;

    public EditarPerfil_controller(Utilizador_servico utilizador_servico,
                                   ContactoDeUtilizador_servico contactoDeUtilizador_servico){
        this.utilizador_servico = utilizador_servico;
        this.contactoDeUtilizador_servico = contactoDeUtilizador_servico;
    }

    @GetMapping
    public String editarPerfilForm(Authentication authentication, Model model){
        String emailUtilizador = authentication.getName(); //username logado
        Utilizador utilizador = utilizador_servico.findByEmail(emailUtilizador); //definir objeto da entidade utilizador


        CriarPerfil_dto criarPerfil_dto = new CriarPerfil_dto();

        //carregar utilizador existente
        Utilizador_dto utilizador_dto = new Utilizador_dto(
                utilizador.getUsername(),
                utilizador.getEmail(),
                null //senha não exibida
        );
        utilizador_dto.setFoto_de_perfil_bytes(utilizador.getFoto_de_perfil());
        criarPerfil_dto.setUtilizador_dto(utilizador_dto); // passa os dados do utilizador logado para o dto principal


        //carregar contactos existentes
        List<ContactoDeUtilizador_dto> contactos_dto = utilizador.getContactosDeUtilizador()
                .stream()
                .map( c-> new ContactoDeUtilizador_dto(
                        c.getForma_de_contacto(),
                        c.getNivel_de_contacto(),
                        c.getContacto(),
                        utilizador
                ))
                .collect(Collectors.toList());

        //garantir 4 contactos no form
        for (int i = 1 ; i <= 4 ; i++){
            if ( i <= contactos_dto.size()){
                contactos_dto.get(i - 1).setNivel_de_contacto(i); // Se já existe, garantir que o nível está certo
            }
            else{
                ContactoDeUtilizador_dto novoContacto = new ContactoDeUtilizador_dto();
                novoContacto.setNivel_de_contacto(i);
                contactos_dto.add(novoContacto);
            }
        }

        //wrapper
        ContactosWrapper_dto wrapper = new ContactosWrapper_dto();
        wrapper.setContactos(contactos_dto);
        criarPerfil_dto.setContactos(wrapper);

        model.addAttribute("editarPerfil_dto", criarPerfil_dto);
        return "editar-perfil";
    }

    @PostMapping
    public String editarPerfilSubmit(@ModelAttribute CriarPerfil_dto editarPerfil_dto,
                                     Authentication authentication,
                                     RedirectAttributes redirectAttributes){

        String emailUtilizador = authentication.getName();
        Utilizador utilizador = utilizador_servico.findByEmail(emailUtilizador);

        try {
            // Atualizar utilizador
            utilizador_servico.atualizar_utilizador(utilizador,
                    editarPerfil_dto.getUtilizador_dto(),
                    editarPerfil_dto.getContactos().getContactos());

            redirectAttributes.addFlashAttribute("sucessoEditarPerfil", true);
            return "redirect:/meuperfil";
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("erroEditarPerfil", e.getMessage());
            return "redirect:/editarperfil";
        }
    }

}