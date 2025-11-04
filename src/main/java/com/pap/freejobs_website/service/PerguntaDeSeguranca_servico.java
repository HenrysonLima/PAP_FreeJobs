package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.PerguntaDeSeguranca_dto;
import com.pap.freejobs_website.entity.PerguntaDeSeguranca;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.PerguntaDeSeguranca_repositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerguntaDeSeguranca_servico {

    private final PerguntaDeSeguranca_repositorio perguntaDeSeguranca_repositorio;

    public PerguntaDeSeguranca_servico(PerguntaDeSeguranca_repositorio perguntaDeSeguranca_repositorio){
        this.perguntaDeSeguranca_repositorio = perguntaDeSeguranca_repositorio;
    }

    public void salvarPerguntas(List<PerguntaDeSeguranca_dto> perguntasDto, Utilizador utilizador){
        if (perguntasDto == null || perguntasDto.isEmpty()) return; //se nao existe pergunta, a funcao encerra

        for(PerguntaDeSeguranca_dto dto : perguntasDto){
            if (dto.getPergunta() == null || dto.getPergunta().isBlank()) continue;
            if (dto.getResposta() == null || dto.getResposta().isBlank()) continue;

            PerguntaDeSeguranca pergunta = new PerguntaDeSeguranca(
                    dto.getPergunta(),
                    dto.getResposta(),
                    utilizador
            );

            perguntaDeSeguranca_repositorio.save(pergunta);
        }

    }
}
