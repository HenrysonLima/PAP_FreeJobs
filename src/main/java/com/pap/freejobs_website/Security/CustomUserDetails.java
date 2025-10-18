package com.pap.freejobs_website.Security;

import com.pap.freejobs_website.entity.Utilizador;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Utilizador utilizador;
    private final Long id;
    private final String email;
    private final String senha;

    // Construtor para a entity completa
    public CustomUserDetails(Utilizador utilizador) {
        this.utilizador = utilizador;
        this.id = utilizador.getId();
        this.email = utilizador.getEmail();
        this.senha = utilizador.getSenha();
    }

    // construtor para o login
    public CustomUserDetails(Long id, String email, String senha) {
        this.utilizador = null;
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
