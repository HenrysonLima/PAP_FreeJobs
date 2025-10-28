package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.ContactoFeito_dto;
import com.pap.freejobs_website.entity.ContactoFeito;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.ContactoFeito_repositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactoFeito_servico {

    private final ContactoFeito_repositorio contactoFeito_repositorio;
    public final MailService mailService;

    public ContactoFeito_servico(ContactoFeito_repositorio contactoFeito_repositorio, MailService mailService){
        this.contactoFeito_repositorio = contactoFeito_repositorio;
        this.mailService = mailService;
    }

    //emails com utilizador autenticado
    public ContactoFeito salvar_contactoFeito_autenticado(ContactoFeito_dto dto, Utilizador utilizador){

        ContactoFeito contactoFeito = new ContactoFeito(
                dto.getAssunto(),
                dto.getMensagem(),
                LocalDateTime.now(), //define dataDoContacto com a data atual
                utilizador
        );

        return contactoFeito_repositorio.save(contactoFeito);
    }

    public void enviarEmail_autenticado(ContactoFeito_dto dto, Utilizador utilizador){

        String assunto = "FreeJobs - " + dto.getAssunto();

        mailService.enviarEmail(assunto, dto.getMensagem(), utilizador.getEmail());
    }

    //emails com utilizador não autenticado
    public ContactoFeito salvar_contactoFeito_naoAutenticado(ContactoFeito_dto dto){

        ContactoFeito contactoFeito = new ContactoFeito(
                dto.getAssunto(),
                dto.getMensagem(),
                LocalDateTime.now(), //define dataDoContacto com a data atual
                dto.getEmailNaoAutenticado()
        );

        return contactoFeito_repositorio.save(contactoFeito);
    }

    public void enviarEmail_naoAutenticado(ContactoFeito_dto dto){
        String assunto = "FreeJobs - " + dto.getAssunto();
        mailService.enviarEmail(assunto, dto.getMensagem(), dto.getEmailNaoAutenticado());
    }

}
