package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.Anuncio_dto;
import com.pap.freejobs_website.entity.Anuncio;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.Anuncio_repositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class Anuncio_servico {

    private final Anuncio_repositorio anuncio_repositorio;

    public Anuncio_servico(Anuncio_repositorio anuncio_repositorio){
        this.anuncio_repositorio = anuncio_repositorio;
    }

    @Transactional
    public Optional<Anuncio> findById(Long id){
        return anuncio_repositorio.findById(id);
    }

    @Transactional
    public Anuncio salvar_anuncio(Anuncio_dto dto){

        byte[] fotoBytes = null;

        try {
            if (dto.getFoto_anuncio() != null && !dto.getFoto_anuncio().isEmpty()){
                fotoBytes = dto.getFoto_anuncio().getBytes(); //converte MultipartFile para byte
            }
        }
        catch (IOException e){
            throw new RuntimeException("Erro ao processar imagem do anuncio", e);
        }

        Anuncio anuncio = new Anuncio(
                dto.getNome_do_anuncio(),
                fotoBytes,
                dto.getPreco(),
                dto.getDescricao(),
                dto.getUtilizador()
        );

        return anuncio_repositorio.save(anuncio);
    }

    @Transactional
    public void excluir_anuncio(Long id, Utilizador utilizador) {
        Anuncio anuncio = anuncio_repositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Anúncio não encontrado"));

        // Segurança: só o dono pode excluir
        if (!anuncio.getUtilizador().equals(utilizador)) {
            throw new SecurityException("Você não pode excluir este anúncio");
        }

        anuncio_repositorio.delete(anuncio);
    }

    // funções para pesquisa
    public List<Anuncio> buscarPorTituloDescricaoOuUtilizador(String termo) {
        return anuncio_repositorio.searchByTituloDescricaoOuUtilizador(termo);
    }

    // para quando o termo de pesquisa é null, carregar os 3 anuncios mais recentes
    public List<Anuncio> buscarUltimos3() {
        return anuncio_repositorio.findTop3ByOrderByIdDesc();
    }

}
