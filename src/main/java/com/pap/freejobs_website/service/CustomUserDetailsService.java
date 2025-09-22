package com.pap.freejobs_website.service;

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
        Utilizador u = repo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Utilizador não encontrado"));

        return org.springframework.security.core.userdetails.User
                .withUsername(u.getEmail())
                .password(u.getSenha())
                .roles("USER")
                .build();
    }
}
