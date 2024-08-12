
package com.digicert.public_api.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/api/weather").permitAll() 
                .anyRequest().denyAll() 
                .and()
            .exceptionHandling()
                .authenticationEntryPoint(new Http403ForbiddenEntryPoint()) 
                .and()
            .csrf().disable()
            .httpBasic().disable(); ;

        return http.build();
    }
    
}
