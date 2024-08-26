package kz.kayaker.botcore.config;

import kz.kayaker.botcore.service.authentication.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static kz.kayaker.botcore.entity.security.Role.ADMIN;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class FilterChainConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(configurer -> configurer.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .authorizeHttpRequests(request -> {
                            request.requestMatchers("/auth/login")
                                   .permitAll();
                            request.requestMatchers("/test/user")
                                   .hasAnyRole("USER", "ADMIN");
                            request.requestMatchers("/test/admin")
                                   .hasAnyRole(ADMIN.name());
                            request.requestMatchers(HttpMethod.POST, "/training")
                                   .hasRole(ADMIN.name());
                            request.requestMatchers(HttpMethod.GET, "/training")
                                   .permitAll();
                            request.requestMatchers("/error")
                                   .anonymous();
                            request.anyRequest()
                                   .authenticated();
                        }
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
