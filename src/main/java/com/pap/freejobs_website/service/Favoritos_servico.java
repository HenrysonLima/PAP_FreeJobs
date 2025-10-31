package com.pap.freejobs_website.service;

import com.pap.freejobs_website.entity.Anuncio;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.Anuncio_repositorio;
import com.pap.freejobs_website.repository.Utilizador_repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Favoritos_servico {

    @Autowired
    private Utilizador_repositorio utilizador_repositorio;

    @Autowired
    private Anuncio_repositorio anuncio_repositorio;

    public void adicionarFavorito(Long anuncioId, Utilizador utilizador){
        Anuncio anuncio = anuncio_repositorio.findById(anuncioId)
                .orElseThrow(() -> new IllegalArgumentException("Anuncio  não encontrado"));

        utilizador.getFavoritos().add(anuncio);

        utilizador_repositorio.save(utilizador);
    }

    public void removerFavorito(Long anuncioId, Utilizador utilizador){
        Anuncio anuncio = anuncio_repositorio.findById(anuncioId)
                .orElseThrow(() -> new IllegalArgumentException("Anuncio  não encontrado"));

        utilizador.getFavoritos().remove(anuncio);

        utilizador_repositorio.save(utilizador);
    }

    public List<Anuncio> listarFavoritos(Utilizador utilizador){
        return utilizador.getFavoritos();
    }

}
