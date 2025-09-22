package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.Utilizador_dto;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.Utilizador_repositorio;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Utilizador_servico {

    private final Utilizador_repositorio utilizador_repositorio;
    private final PasswordEncoder passwordEncoder;

    public Utilizador_servico(Utilizador_repositorio utilizadorRepositorio, PasswordEncoder passwordEncoder){
        this.utilizador_repositorio = utilizadorRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public Utilizador salvar_utilizador(Utilizador_dto dto) {

        //Regras de negócio
        if(utilizador_repositorio.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email já existente");
        }

        //conversão MultipartFile para byte[]
        byte[] fotoBytes = null;
        byte[] cvBytes = null;

        try{
            if(dto.getFoto_de_perfil() != null && !dto.getFoto_de_perfil().isEmpty()){
                fotoBytes = dto.getFoto_de_perfil().getBytes();
            }
            if(dto.getCv() != null && !dto.getCv().isEmpty()){
                cvBytes = dto.getCv().getBytes();
            }
        }
        catch (IOException e){
            throw new RuntimeException("Erro ao processar ficheiros", e);
        }

        Utilizador utilizador = new Utilizador(
                dto.getUsername(),
                dto.getEmail(),
                dto.getSenha(),
                fotoBytes,
                cvBytes
        );

        utilizador.setSenha(passwordEncoder.encode(utilizador.getSenha()));// hash password

        return utilizador_repositorio.save(utilizador);
    }
}
