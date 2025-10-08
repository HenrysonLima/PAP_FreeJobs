package com.pap.freejobs_website.service;

import com.pap.freejobs_website.Security.CustomUserDetails;
import com.pap.freejobs_website.entity.Utilizador;
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
        Utilizador utilizador = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilizador não encontrado"));

        //retornar CustomUserDetails ao invés de padrão
        return new CustomUserDetails(utilizador);
    }
}
