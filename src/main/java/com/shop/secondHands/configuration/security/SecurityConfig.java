package com.shop.secondHands.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
                        .requestMatchers("/main").permitAll()
                        .requestMatchers("/main/**").hasRole("USER")
                        .requestMatchers("/image/**").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                        .anyRequest().authenticated())
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/main"))
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/main/logout"))
                        .logoutSuccessUrl("/main")
                        .invalidateHttpSession(true))
        ;
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
