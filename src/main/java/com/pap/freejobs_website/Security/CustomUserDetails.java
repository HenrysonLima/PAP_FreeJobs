package com.pap.freejobs_website.Security;

import com.pap.freejobs_website.entity.Utilizador;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Utilizador utilizador;

    public CustomUserDetails(Utilizador utilizador){
        this.utilizador=utilizador;
    }

    public Long getId(){
        return  utilizador.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Collections.emptyList();
    }

    @Override
    public String getUsername(){
        return utilizador.getEmail();
    }

    @Override
    public String getPassword(){
        return utilizador.getSenha();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
