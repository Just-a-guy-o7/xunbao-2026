package com.Xunbao2026.Xunbao2026.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(requests -> requests
            .requestMatchers("/**").authenticated()
                .anyRequest().authenticated());

            // .antMatchers("/user/**").authenticated()
            // .antMatchers("/api/**").authenticated()
            // .antMatchers("/**").permitAll()
            // .anyRequest().authenticated();

        httpSecurity.formLogin(formLogin -> {
            formLogin
                    .loginPage("/login")
                    .loginProcessingUrl("/authenticate")
                    .successForwardUrl("/dashboard")
                    .failureForwardUrl("/signUp?error=true")
                    .usernameParameter("Username")
                    .passwordParameter("password");
        });

        httpSecurity.csrf(customizer -> customizer.disable());
        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.logout(logout -> logout
                .logoutUrl("/do-logout")
                .logoutSuccessUrl("/login?logout=true"));

        httpSecurity.csrf(AbstractHttpConfigurer::disable);


         
        return httpSecurity.build();
    }
}
