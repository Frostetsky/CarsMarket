package com.carmarket.app.security;

import com.carmarket.app.model.User;
import com.carmarket.app.util.ContextUtil;
import com.carmarket.app.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private ContextUtil contextUtil;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ContextUtil contextUtil) {
        this.authenticationManager = authenticationManager;
        this.contextUtil = contextUtil;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword(),
                            user.getAuthorities()
                    ));
        } catch (Exception e) {
            log.error("Ошибка в {}. Сообщение об ошибки {}", this.getClass().getSimpleName(), e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String username = contextUtil.getUserName();
        String jwtToken = JwtUtil.generateToken(username);

        response.addCookie(new Cookie(JwtUtil.ID_TOKEN, JwtUtil.TOKEN_PREFIX + jwtToken));
    }
}
