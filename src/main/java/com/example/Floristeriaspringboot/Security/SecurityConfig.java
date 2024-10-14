
package com.example.Floristeriaspringboot.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests
                    .requestMatchers("/login", "/public/**").permitAll()  // Permitir acceso a estas rutas sin autenticación
                    .anyRequest().authenticated()                          // Requerir autenticación para otras rutas
            )
            .formLogin(formLogin ->
                formLogin
                    .loginPage("/login")                             // Definir la página de inicio de sesión personalizada
                    .permitAll()                                     // Permitir acceso sin autenticación a la página de inicio de sesión
            )
            .logout(logout -> 
                logout.permitAll());                               // Permitir el cierre de sesión a todos

        return http.build();
    }
}
