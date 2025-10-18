package com.pap.freejobs_website.service;

import com.pap.freejobs_website.repository.UtilizadorLoginProjection;
import com.pap.freejobs_website.repository.Utilizador_repositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final Utilizador_repositorio repo;

    public CustomUserDetailsService(Utilizador_repositorio repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UtilizadorLoginProjection utilizadorProjection = repo.findUserForLogin(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilizador não encontrado"));

        // puxa o ID do utilizador usando o construtor light
        Long id = repo.findIdByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilizador não encontrado"));

        // Retornar CustomUserDetails ao invés de utilizador padrão do Spring
        return new com.pap.freejobs_website.Security.CustomUserDetails(id, utilizadorProjection.getEmail(), utilizadorProjection.getSenha());
    }
}
