package com.pap.freejobs_website.repository;

import com.pap.freejobs_website.entity.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface Utilizador_repositorio extends JpaRepository<Utilizador, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<Utilizador> findByEmail(String email);
    Optional<Utilizador> findByUsername(String username);

    @Query("SELECT u.email AS email, u.senha AS senha FROM Utilizador u WHERE u.email = :email")
    Optional<UtilizadorLoginProjection> findUserForLogin(@Param("email") String email);
}
