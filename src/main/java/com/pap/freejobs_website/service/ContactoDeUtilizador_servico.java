package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.ContactoDeUtilizador_dto;
import com.pap.freejobs_website.entity.ContactoDeUtilizador;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.ContactoDeUtilizador_repositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoDeUtilizador_servico {
    private final ContactoDeUtilizador_repositorio contactoDeUtilizador_repositorio;

    public ContactoDeUtilizador_servico(ContactoDeUtilizador_repositorio contactoDeUtilizador_repositorio){
        this.contactoDeUtilizador_repositorio = contactoDeUtilizador_repositorio;
    }

    public void salvar_contacto(List<ContactoDeUtilizador_dto> contactos, Utilizador utilizador){

        //filtro para salvar apenas contactos que nao estejam vazios
        List<ContactoDeUtilizador_dto> contactosPreenchidos = contactos.stream()
                .filter(c -> c.getForma_de_contacto() != null && !c.getForma_de_contacto().equals("none")
                        && c.getContacto() != null && !c.getContacto().isBlank())
                .toList();

        //ciclo estilo foreach para salvar os contactos preenchidos na base de dados
        for (ContactoDeUtilizador_dto dto : contactosPreenchidos){
            ContactoDeUtilizador contactoDeUtilizador = new ContactoDeUtilizador(
                    dto.getForma_de_contacto(),
                    dto.getNivel_de_contacto(),
                    dto.getContacto(),
                    utilizador
            );
            contactoDeUtilizador_repositorio.save(contactoDeUtilizador);
        }


    }
}