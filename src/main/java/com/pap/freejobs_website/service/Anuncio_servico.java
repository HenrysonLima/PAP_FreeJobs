package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.Anuncio_dto;
import com.pap.freejobs_website.entity.Anuncio;
import com.pap.freejobs_website.repository.Anuncio_repositorio;
import org.springframework.stereotype.Service;

@Service
public class Anuncio_servico {

    private final Anuncio_repositorio anuncio_repositorio;

    public Anuncio_servico(Anuncio_repositorio anuncio_repositorio){
        this.anuncio_repositorio = anuncio_repositorio;
    }

    public Anuncio salvar_anuncio(Anuncio_dto dto){
        Anuncio anuncio = new Anuncio(
                dto.getNome_do_anuncio(),
                dto.getFoto_anuncio(),
                dto.getPreco(),
                dto.getDescricao(),
                dto.getUtilizador()
        );

        return anuncio_repositorio.save(anuncio);
    }
}
