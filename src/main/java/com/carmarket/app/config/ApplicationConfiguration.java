package com.carmarket.app.config;

import com.carmarket.app.security.LogoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean("page")
    public PageRequest pageRequest() {
        return PageRequest.of(0, 5);
    }

    @Bean
    public LogoutHandler logoutHandler() {
        return new LogoutHandler();
    }
}
