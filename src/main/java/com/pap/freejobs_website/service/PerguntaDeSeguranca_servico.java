package com.pap.freejobs_website.service;

import com.pap.freejobs_website.dto.PerguntaDeSeguranca_dto;
import com.pap.freejobs_website.entity.PerguntaDeSeguranca;
import com.pap.freejobs_website.entity.Utilizador;
import com.pap.freejobs_website.repository.PerguntaDeSeguranca_repositorio;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerguntaDeSeguranca_servico {

    private final PerguntaDeSeguranca_repositorio perguntaDeSeguranca_repositorio;
    private final Utilizador_servico utilizador_servico;

    public PerguntaDeSeguranca_servico(Utilizador_servico utilizador_servico, PerguntaDeSeguranca_repositorio perguntaDeSeguranca_repositorio){
        this.perguntaDeSeguranca_repositorio = perguntaDeSeguranca_repositorio;
        this.utilizador_servico = utilizador_servico;
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

    @Transactional(readOnly = true)
    public List<PerguntaDeSeguranca_dto> buscarPerguntasDoUtilizador(Utilizador utilizador){
        return perguntaDeSeguranca_repositorio.findByUtilizador(utilizador)
                .stream()
                .map(PerguntaDeSeguranca_dto::new)
                .toList();
    }

    public void validarRespostasEAtualizarSenha(String email, List<String> respostas, String novaSenha) {
        Utilizador utilizador = utilizador_servico.findByEmail(email);
        if (utilizador == null) {
            throw new IllegalArgumentException("Utilizador não encontrado.");
        }

        List<PerguntaDeSeguranca> perguntas = perguntaDeSeguranca_repositorio.findByUtilizador(utilizador);

        if (perguntas.size() != respostas.size()) {
            throw new IllegalArgumentException("Número de respostas inválido.");
        }

        for (int i = 0; i < perguntas.size(); i++) {
            if (!perguntas.get(i).getResposta().equalsIgnoreCase(respostas.get(i).trim())) {
                throw new IllegalArgumentException("Resposta incorreta para a pergunta " + (i + 1));
            }
        }

        utilizador_servico.atualizarSenha(utilizador, novaSenha);
    }
}
