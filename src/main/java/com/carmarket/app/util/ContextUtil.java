package com.carmarket.app.util;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class ContextUtil {

    public String getUserName() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(auth -> (UserDetails) auth.getPrincipal())
                .map(UserDetails::getUsername)
                .orElseThrow(() -> new NoSuchElementException("Ошибка получение логина из контекста."));
    }
}
