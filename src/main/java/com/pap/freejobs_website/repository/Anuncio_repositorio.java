package com.pap.freejobs_website.repository;

import com.pap.freejobs_website.entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Anuncio_repositorio extends JpaRepository<Anuncio, Long> {
    List<Anuncio> findBytituloContainingIgnoreCase(String termo);
    List<Anuncio> findTop3ByOrderByIdDesc();
}
