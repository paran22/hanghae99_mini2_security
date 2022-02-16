package com.example.hanghae99_mini2.model;

import java.util.Collection;

public class AuthenticationToken {

    private Long userId;
    private Collection authorities;
    private String token;

    public AuthenticationToken(Long userId, Collection collection, String token) {
        this.userId = userId;
        this.authorities = collection;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Collection getAuthorities() {
        return authorities;
    }
    public void setAuthorities(Collection authorities) {
        this.authorities = authorities;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}