package com.alibou.book.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ExtrasSecurityConfig {

    @Bean
    @Order(20)
    public SecurityFilterChain extrasSecurityChain(HttpSecurity http) throws Exception {
        http.securityMatcher(new AntPathRequestMatcher("/management/**"))
                .authorizeHttpRequests(requests -> requests.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
