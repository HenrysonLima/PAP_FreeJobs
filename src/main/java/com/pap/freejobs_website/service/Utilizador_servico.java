package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.ContactoDeUtilizador_dto;
import com.pap.freejobs_website.dto.Utilizador_dto;
import com.pap.freejobs_website.entity.ContactoDeUtilizador;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.Utilizador_repositorio;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Utilizador_servico {

    private final Utilizador_repositorio utilizador_repositorio;
    private final PasswordEncoder passwordEncoder;

    public Utilizador_servico(Utilizador_repositorio utilizadorRepositorio, PasswordEncoder passwordEncoder){
        this.utilizador_repositorio = utilizadorRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public void processar_ficheiros(Utilizador utilizador, Utilizador_dto dto){
        //conversão MultipartFile para byte[]
        byte[] fotoBytes = null;
        byte[] cvBytes = null;

        try{
            if(dto.getFoto_de_perfil() != null && !dto.getFoto_de_perfil().isEmpty()){
                fotoBytes = dto.getFoto_de_perfil().getBytes();
                utilizador.setFoto_de_perfil(fotoBytes);
            }
            if(dto.getCv() != null && !dto.getCv().isEmpty()){
                cvBytes = dto.getCv().getBytes();
                utilizador.setCv(cvBytes);
            }
        }
        catch (IOException e){
            throw new RuntimeException("Erro ao processar ficheiros", e);
        }
    }

    public Utilizador salvar_utilizador(Utilizador_dto dto) {

        //Regras de negócio
        if(utilizador_repositorio.existsByEmail(dto.getEmail()) || utilizador_repositorio.existsByUsername(dto.getUsername())){
            throw new IllegalArgumentException("Credenciais já existentes");
        }

        Utilizador utilizador = new Utilizador(
                dto.getUsername(),
                dto.getEmail(),
                dto.getSenha()
        );

        utilizador.setSenha(passwordEncoder.encode(utilizador.getSenha()));// hash password

        processar_ficheiros(utilizador,dto);

        return utilizador_repositorio.save(utilizador);
    }

    //Editar perfil
    public Utilizador findByEmail(String email){
        return utilizador_repositorio.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("Utilizador não encontrado"));
    }



    @Transactional
    public void atualizar_utilizador(Utilizador utilizador,
                                             Utilizador_dto dto,
                                             List<ContactoDeUtilizador_dto> contactos_dto){

        if(dto.getUsername() != null && !dto.getUsername().isBlank()
            && !dto.getUsername().equals(utilizador.getUsername())){
            utilizador.setUsername(dto.getUsername());
        }

        processar_ficheiros(utilizador, dto);

        // Atualizar contactos
        utilizador.getContactosDeUtilizador().clear(); // Limpa a lista de contactos

        // criar novos contactos
        for (ContactoDeUtilizador_dto cDto : contactos_dto){
            if(cDto.getForma_de_contacto() != null && !cDto.getForma_de_contacto().equals("none")){
                ContactoDeUtilizador contactoDeUtilizador = new ContactoDeUtilizador();
                contactoDeUtilizador.setForma_de_contacto(cDto.getForma_de_contacto());
                contactoDeUtilizador.setNivel_de_contacto(cDto.getNivel_de_contacto());
                contactoDeUtilizador.setContacto(cDto.getContacto());
                contactoDeUtilizador.setUtilizador(utilizador);
                utilizador.getContactosDeUtilizador().add(contactoDeUtilizador);
            }
        }

        utilizador_repositorio.save(utilizador);
    }

}
