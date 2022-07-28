package com.app.crud;

// code partially used from: https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
//  https://github.com/koushikkothagal/spring-security-jpa

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/logout").authenticated()
                .antMatchers("/login*").anonymous()
                .antMatchers("/register*").anonymous()
                .antMatchers("/", "/resources/**", "/static/**", "/css/**", "/js/**", "/images/**",
                        "/vendor/**","/fonts/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .and()
            .logout()
                .logoutUrl("/logout");

        return http.build();
    }
}