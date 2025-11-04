package com.pap.freejobs_website.repository;

import com.pap.freejobs_website.entity.PerguntaDeSeguranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaDeSeguranca_repositorio  extends JpaRepository<PerguntaDeSeguranca, Long> {
}
