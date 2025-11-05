package com.pap.freejobs_website.repository;

import com.pap.freejobs_website.entity.PerguntaDeSeguranca;
import com.pap.freejobs_website.entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerguntaDeSeguranca_repositorio  extends JpaRepository<PerguntaDeSeguranca, Long> {
    List<PerguntaDeSeguranca> findByUtilizador(Utilizador utilizador);
}
