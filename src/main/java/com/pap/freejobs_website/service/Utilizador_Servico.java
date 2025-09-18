package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.Utilizador_dto;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.Utilizador_repositorio;
import org.springframework.stereotype.Service;

@Service
public class Utilizador_Servico {

    private final Utilizador_repositorio utilizador_repositorio;

    public Utilizador_Servico(Utilizador_repositorio utilizadorRepositorio){
        this.utilizador_repositorio = utilizadorRepositorio;
    }

    public Utilizador salvar_utilizador(Utilizador_dto dto) {

        //Regras de negócio
        if(utilizador_repositorio.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email já existente");
        }
        Utilizador utilizador = new Utilizador(
                dto.getUsername(),
                dto.getEmail(),
                dto.getSenha(),
                dto.getUrl_foto_de_perfil(),
                dto.getUrl_CV()
        );
        return utilizador_repositorio.save(utilizador);
    }
}
