package com.pap.freejobs_website.repository;

import com.pap.freejobs_website.entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Anuncio_repositorio extends JpaRepository<Anuncio, Long> {
    @Query("""
       SELECT a FROM Anuncio a
       WHERE LOWER(a.titulo) LIKE LOWER(CONCAT('%', :termo, '%'))
          OR LOWER(a.descricao) LIKE LOWER(CONCAT('%', :termo, '%'))
          OR LOWER(a.utilizador.username) LIKE LOWER(CONCAT('%', :termo, '%'))
       """)
    List<Anuncio> searchByTituloDescricaoOuUtilizador(@Param("termo") String termo);
    List<Anuncio> findTop3ByOrderByIdDesc();
}
