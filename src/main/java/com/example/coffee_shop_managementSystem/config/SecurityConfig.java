package com.example.coffee_shop_managementSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().permitAll() // اسمح بالوصول إلى جميع المسارات دون تسجيل دخول
            )
            .csrf().disable(); // تعطيل حماية CSRF (لأغراض التطوير فقط)

        return http.build();
    }
}