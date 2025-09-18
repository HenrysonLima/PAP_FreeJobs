package com.pap.freejobs_website.repository;

import com.pap.freejobs_website.entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Utilizador_repositorio extends JpaRepository<Utilizador, Long> {
    boolean existsByEmail(String email);
}
