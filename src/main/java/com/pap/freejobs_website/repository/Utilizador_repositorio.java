package com.pap.freejobs_website.repository;

import com.pap.freejobs_website.entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Utilizador_repositorio extends JpaRepository<Utilizador, Long> {
    boolean existsByEmail(String email);

    Optional<Utilizador> findByEmail(String email);
}
